<?php 
	header("Access-Control-Allow-Origin: * ");
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../connection.php';


if (!empty($_GET['id'])) {
    $consulta = $DB->query("SELECT * FROM public.ticket WHERE id = ".$_GET['id']);
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