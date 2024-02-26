<?php 
	header("Access-Control-Allow-Origin: * ");
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../connection.php';


    if (!empty($_GET['id'])) {
        $consulta = $DB->query("SELECT t.*, p.name AS parking_name, p.address AS parking_addres FROM ticket AS t JOIN parking_seller AS ps ON t.parking_id = ps.id_parking_seller JOIN user AS u ON ps.user_id = u.id JOIN parking AS p ON ps.parking_id = p.id WHERE u.id =".$_GET['id']);
        $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
        if (sizeof($datos)>0) {
            $respuesta = [
                            'status' => true,
                            'message' => "OK##DATOS##GET",
                            'datos' => $datos
                        ];
        }else{
            $respuesta = [
                            'status' => false,
                            'message' => "Ticket no encontrado",
                            '$_GET' => $_GET,
                            '$_POST' => $_POST
                        ];
        }
        echo json_encode($respuesta);
    }else{
        $respuesta = [
                        'status' => false,
                        'message' => "Debe ingresar el id del ticket",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                    ];
        echo json_encode($respuesta);
    }

?>


