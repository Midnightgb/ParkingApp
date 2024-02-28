<?php 
    header("Access-Control-Allow-Origin: * ");
    header("Access-Control-Allow-Methods: GET, POST");
    header("Access-Control-Allow-Headers: Content-Type");

    include '../connection.php';

    if (!empty($_GET['id'])) {
        $user_id = $_GET['id'];

        $consulta_vendedor = $DB->query("SELECT * FROM parking_seller WHERE user_id = $user_id");
        $datos_vendedor = $consulta_vendedor->fetchAll(PDO::FETCH_ASSOC);

        if (sizeof($datos_vendedor) > 0) {
            $parkings_info = [];

            foreach ($datos_vendedor as $vendedor_info) {
                $parking_id = $vendedor_info['parking_id'];

                $consulta_parking = $DB->query("SELECT * FROM parking WHERE id = $parking_id");
                $datos_parking = $consulta_parking->fetchAll(PDO::FETCH_ASSOC);

                if (sizeof($datos_parking) > 0) {
                    $parkings_info[] = $datos_parking[0];
                }
            }

            $respuesta = [
                'status' => true,
                'message' => "OK",
                'vendedor_info' => $datos_vendedor[0], 
                'parkings' => $parkings_info
            ];
        } else {

            $respuesta = [
                'status' => false,
                'message' => "El vendedor no existe",
                '$_GET' => $_GET
            ];
        }
    } else {
    
        $respuesta = [
            'status' => false,
            'message' => "Debe ingresar el ID del vendedor en la solicitud GET",
            '$_GET' => $_GET
        ];
    }

    echo json_encode($respuesta);
?>
