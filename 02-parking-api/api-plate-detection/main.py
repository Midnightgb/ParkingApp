import base64
from typing import Dict
from fastapi import FastAPI, File, HTTPException, Request, UploadFile, WebSocket, WebSocketDisconnect, Form
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
        if client_id == 'camara':
            data = await websocket.receive_text()
            if data:
                image_bytes = base64.b64decode(data)
                with open("placa.png", "wb") as f:
                    f.write(image_bytes)
                placa_text = analysis_image()
                print(placa_text)
        else:        
            while True:
                data = await websocket.receive_text()
                print("Datos recibidos del WebSocket:", data)
                if data == "take_photo":
                    camara = connections.get("camara")
                    await camara.send_text("capture_photo")

    except WebSocketDisconnect:
        connections.pop(client_id)
        await websocket.close()

