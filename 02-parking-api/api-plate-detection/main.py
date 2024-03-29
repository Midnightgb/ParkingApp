import base64
from typing import Dict
from fastapi import FastAPI, WebSocket, WebSocketDisconnect
import base64

from detect_plate import analysis_image

app = FastAPI()

connections_client: Dict[str, WebSocket] = {}
connection_camaras = []
cliente_get_photo = ""
camera_now = 0
plate_to_be_found = ""
nombre_end_camera = ""
@app.websocket("/ws/{client_id}")
async def websocket_endpoint(websocket: WebSocket, client_id: str):
    print(f"peticiones de clientes: {client_id}")
    global cliente_get_photo  
    global camera_now
    global plate_to_be_found


    await websocket.accept()
    try:
        if 'camara' in client_id:
            existing_connection = next((conn for conn in connection_camaras if conn[0] == client_id), None)
            if existing_connection:
                existing_connection[1] = websocket 
            else:
                connection_camaras.append([client_id, websocket]) 
            data_img = await websocket.receive_text()
            if data_img:
                print(f"data: {data_img}")
                image_bytes = base64.b64decode(data_img)
                with open("placa.png", "wb") as f:
                    f.write(image_bytes)
                placas_text, url_image = analysis_image()
                print(placas_text)
                print(url_image)
                camera_now = (camera_now + 1)
                send_request = validationPlateFound(placas_text)
                if send_request:
                    text_cliente = nombre_end_camera+","+url_image
                    print(cliente_get_photo)
                    print(connections_client)
                    connection_client = connections_client.get(cliente_get_photo)
                    print(connection_client)
                    if connection_client:
                        print("se envian datos al cliente")
                        await connection_client.send_text(text_cliente)
                elif camera_now < len(connection_camaras):
                    print("tomar foto")
                    await get_photo()
                else:
                    print("placa no encontrada")
        elif 'cliente' in client_id:
            cliente_get_photo = client_id
            connections_client[client_id] = websocket
            while True:
                data = await websocket.receive_text()
                print("Datos recibidos del WebSocket:", data)
                if data:
                    plate_to_be_found = data
                    camera_now = 0
                    await get_photo()           
    except WebSocketDisconnect:
        print(f"La conexión del cliente {client_id} se ha cerrado.")
        if client_id == 'camara':
            pass
        elif client_id == 'cliente':
            pass

async def get_photo():
    global nombre_end_camera

    if camera_now < len(connection_camaras):
        nombre, coneccion = connection_camaras[camera_now]
        nombre_end_camera = nombre
        print(nombre)
        try:
            await coneccion.send_text("capture_photo")
        except WebSocketDisconnect:
            print("La conexión del WebSocket ya se ha cerrado.")
    else:
        print("El valor de camera_now está fuera del rango de la lista connection_camaras.")



def validationPlateFound(arreglo_placas):
    for placa in arreglo_placas:
        print(f"{placa} == {plate_to_be_found}")
        if placa == plate_to_be_found:
            print("si igual")
            return True
    return False

# wscat -c ws://192.168.1.1/ws/cliente_antonio