from typing import Dict
from fastapi import FastAPI, File, UploadFile, WebSocket, WebSocketDisconnect
from fastapi.responses import JSONResponse
from fastapi.middleware.cors import CORSMiddleware

from detect_plate import analysis_image

app = FastAPI()
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)
connections: Dict[str, WebSocket] = {}

@app.websocket("/ws/{client_id}")
async def websocket_endpoint(websocket: WebSocket, client_id: str):
    await websocket.accept()
    connections[client_id] = websocket
    try:
        while True:
            data = await websocket.receive_text()
            print("Datos recibidos del WebSocket:", data)
            if data == "take_photo":
                camara = connections.get("camara")
                await camara.send_text("capture_photo")

    except WebSocketDisconnect:
        connections.pop(client_id)
        await websocket.close()

@app.post("/upload/")
async def upload_image(file: UploadFile = File(...)):
    try:
        contents = await file.read()
        
        with open("placa.png", "wb") as f:
            f.write(contents)
        # cliente = connections.get("cliente_get_foto")
        # placa_text = analysis_image()
        # print(placa_text)
        # await cliente.send_text(placa_text)
        return JSONResponse(content={"filename": "placa.png"}, status_code=201)
    except Exception as e:
        return JSONResponse(content={"error": str(e)}, status_code=500)
