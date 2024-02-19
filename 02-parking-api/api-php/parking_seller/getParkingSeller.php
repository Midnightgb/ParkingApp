<?php 
	header("Access-Control-Allow-Origin: * ");
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../connection.php';


if (!empty($_GET['id'])) {
    $consulta = $base_de_datos->query("SELECT * FROM parking_seller WHERE id = ".$_GET['id']);
    $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
    if (sizeof($datos)>0) {
        $respuesta = [
                        'status' => true,
                        'message' => "OK##DATOS##GET",
                        'datos' => $datos[0]
                    ];
    }else{
        $respuesta = [
                        'status' => false,
                        'message' => "El vendendor no existe",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                    ];
    }
    echo json_encode($respuesta);
}else{
    $respuesta = [
                    'status' => false,
                    'message' => "Debe ingresar el id del vendedor",
                    '$_GET' => $_GET,
                    '$_POST' => $_POST
                ];
    echo json_encode($respuesta);
}

?>