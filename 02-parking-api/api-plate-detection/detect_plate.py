from github import Github
from azure.cognitiveservices.vision.computervision import ComputerVisionClient
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes
from msrest.authentication import CognitiveServicesCredentials
import time


def analysis_image():

    g = Github("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")


    repo = g.get_user("jefryne").get_repo("img_placas")

    contents = repo.get_contents("")

    last_image_number = 0
    for content in contents:
        if content.name.startswith("imagen_") and content.name.endswith(".png"):
            number_str = content.name.split("_")[1].split(".")[0]
            number = int(number_str)
            if number > last_image_number:
                last_image_number = number

    new_image_number = last_image_number + 1
    new_file_name = f"imagen_{new_image_number}.png"

    file_path = "placa.png"

    with open(file_path, "rb") as file:
        content = file.read()
        repo.create_file(new_file_name, "Mensaje de commit", content)

    image_url = f"https://raw.githubusercontent.com/{repo.owner.login}/{repo.name}/master/{new_file_name}"
    print("URL de la imagen en GitHub:", image_url)

    subscription_key = "837074e52a12465c9b4789b5fa964dd7"
    endpoint = "https://vision-placas.cognitiveservices.azure.com/"

    computervision_client = ComputerVisionClient(endpoint, CognitiveServicesCredentials(subscription_key))

    read_response = computervision_client.read(image_url,  raw=True)

    read_operation_location = read_response.headers["Operation-Location"]
    # Grab the ID from the URL
    operation_id = read_operation_location.split("/")[-1]

    # Call the "GET" API and wait for it to retrieve the results 
    while True:
        read_result = computervision_client.get_read_result(operation_id)
        if read_result.status not in ['notStarted', 'running']:
            break
        time.sleep(1)
    texto_placas
    if read_result.status == OperationStatusCodes.succeeded:
        for text_result in read_result.analyze_result.read_results:
            for line in text_result.lines:
                if len(line.text) == 7 and (line.text[3] == ' ' or line.text[3] == '-'):
                    texto_placas =texto_placas+line.text+","
                    print("Placa encontrada:", line.text)
                    # print("Coordenadas de la caja delimitadora:", line.bounding_box)
    return texto_placas



