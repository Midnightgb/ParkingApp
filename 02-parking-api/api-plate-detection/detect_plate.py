from github import Github
from azure.cognitiveservices.vision.computervision import ComputerVisionClient
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes
from msrest.authentication import CognitiveServicesCredentials
import time

# Autenticación en GitHub
g = Github("")

# Obtén el repositorio
repo = g.get_user("jefryne").get_repo("img_placas")

# Ruta del archivo de la imagen local
file_path = "pico.png"

# Nombre del archivo en GitHub
file_name = "picos.png"

# Carga la imagen al repositorio
with open(file_path, "rb") as file:
    content = file.read()
    repo.create_file(file_name, "Mensaje de commit", content)

# Obtén la URL de la imagen cargada en GitHub
image_url = f"https://raw.githubusercontent.com/{repo.owner.login}/{repo.name}/master/{file_name}"
print("URL de la imagen en GitHub:", image_url)

'''
Authenticate
Authenticates your credentials and creates a client.
'''
subscription_key = "837074e52a12465c9b4789b5fa964dd7"
endpoint = "https://vision-placas.cognitiveservices.azure.com/"

computervision_client = ComputerVisionClient(endpoint, CognitiveServicesCredentials(subscription_key))
'''
END - Authenticate
'''

'''
OCR: Read File using the Read API, extract text - remote
This example will extract text in an image, then print results, line by line.
This API call can also extract handwriting style text (not shown).
'''
print("===== Read File - remote =====")
# Call API with URL and raw response (allows you to get the operation location)
read_response = computervision_client.read(image_url,  raw=True)

# Get the operation location (URL with an ID at the end) from the response
read_operation_location = read_response.headers["Operation-Location"]
# Grab the ID from the URL
operation_id = read_operation_location.split("/")[-1]

# Call the "GET" API and wait for it to retrieve the results 
while True:
    read_result = computervision_client.get_read_result(operation_id)
    if read_result.status not in ['notStarted', 'running']:
        break
    time.sleep(1)

# Print the detected text, line by line
if read_result.status == OperationStatusCodes.succeeded:
    for text_result in read_result.analyze_result.read_results:
        for line in text_result.lines:
            print(line.text)
            print(line.bounding_box)
print()
'''
END - Read File - remote
'''

print("End of Computer Vision quickstart.")
