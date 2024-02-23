import base64
from typing import Dict
from fastapi import FastAPI, WebSocket, WebSocketDisconnect

from detect_plate import analysis_image

app = FastAPI()

connections_client: Dict[str, WebSocket] = {}
connection_camaras = []
cliente_get_photo = ""
camera_now = 0

@app.websocket("/ws/{client_id}")
async def websocket_endpoint(websocket: WebSocket, client_id: str):
    global cliente_get_photo  
    global camera_now

    await websocket.accept()
    try:
        if 'camara' in client_id:
            connection_camaras.append([client_id, websocket])
            data_img = await websocket.receive_text()
            if data_img:
                print("chao")
                image_bytes = base64.b64decode(data_img)
                with open("placa.png", "wb") as f:
                    f.write(image_bytes)
                placa_text = analysis_image()
                print(placa_text)
                print(len(connection_camaras))
                camera_now = (camera_now + 1)
                print(camera_now)
                if placa_text:
                    connection_client = connections_client.get(cliente_get_photo)
                    if connection_client:
                        await connection_client.send_text(placa_text)
                elif camera_now < len(connection_camaras):
                    print("tomar foto")
                    await get_photo()
                else:
                    camera_now = 0
                    print("placa no encontrada")
        elif 'cliente' in client_id:
            cliente_get_photo = client_id
            while True:
                data = await websocket.receive_text()
                print("Datos recibidos del WebSocket:", data)
                if data == "take_photo":
                    await get_photo()           
    except WebSocketDisconnect:
        print(f"La conexión del cliente {client_id} se ha cerrado.")
        if client_id == 'camara':
            # Manejar el cierre de conexión para cámaras
            # Puedes eliminar la conexión cerrada de la lista connection_camaras
            pass
        elif client_id == 'cliente':
            # Manejar el cierre de conexión para clientes
            # Puedes eliminar la conexión cerrada de la lista connections_client
            pass

async def get_photo():
    if camera_now < len(connection_camaras):
        nombre, coneccion = connection_camaras[camera_now]
        try:
            await coneccion.send_text("capture_photo")
        except WebSocketDisconnect:
            print("La conexión del WebSocket ya se ha cerrado.")
    else:
        # Manejar el caso en el que camera_now sea mayor o igual que la longitud de connection_camaras
        # Esto puede ser un error o puedes querer manejarlo de alguna otra manera según tu lógica de negocio.
        print("El valor de camera_now está fuera del rango de la lista connection_camaras.")
