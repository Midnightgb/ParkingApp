from github import Github
from azure.cognitiveservices.vision.computervision import ComputerVisionClient
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes
from msrest.authentication import CognitiveServicesCredentials
from imgurpython import ImgurClient
import time
from datetime import datetime

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

    image_url_github = f"https://raw.githubusercontent.com/{repo.owner.login}/{repo.name}/master/{new_file_name}"
    print("URL de la imagen en GitHub:", image_url_github)


    client = ImgurClient("134f614ab8eacd1", "fadaf1c7861652879701a219d58bb47cb541102d")

    album = None 
    image_url = image_url_github

    config = {
        'album': album,
        'name':  'Catastrophe!',
        'title': 'Catastrophe!',
        'description': 'Cute kitten being cute on {0}'.format(datetime.now())
    }

    print("Uploading image... ")
    image = client.upload_from_url(image_url, config=config, anon=False)
    print(image['link'])
    url_azure = image['link']

    subscription_key = "211a2a34bfac46b8860fa706aec114b3"
    endpoint = "https://vision-placas.cognitiveservices.azure.com/"

    computervision_client = ComputerVisionClient(endpoint, CognitiveServicesCredentials(subscription_key))

    read_response = computervision_client.read(url_azure, raw=True)

    read_operation_location = read_response.headers["Operation-Location"]
    operation_id = read_operation_location.split("/")[-1]

    while True:
        read_result = computervision_client.get_read_result(operation_id)
        if read_result.status not in ['notStarted', 'running']:
            break
        time.sleep(1)
    texto_placas = []
    if read_result.status == OperationStatusCodes.succeeded:
        for text_result in read_result.analyze_result.read_results:
            for line in text_result.lines:
                print(line.text)
                if len(line.text) == 7 and (line.text[3] == ' ' or line.text[3] == '-' or line.text[3] == '.' or line.text[3] == '®'):
                    texto_placas.append(line.text)
    return texto_placas, url_azure

