<?php 
	header("Access-Control-Allow-Origin: * ");
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include '../connection.php';


if (!empty($_GET['plate'])) {
    
    $query = "SELECT * FROM vehicle WHERE plate = :plt";
    $consulta = $DB->prepare($query);
    $consulta->bindParam(':plt', $_GET['plate'], PDO::PARAM_INT);
    $consulta->execute();

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
                        'message' => "CATEGORIA NO ENCONTRADA",
                        '$_GET' => $_GET,
                        '$_POST' => $_POST
                    ];
    }
    echo json_encode($respuesta);
}else{
    $respuesta = [
                    'status' => false,
                    'message' => "INGRESE UN ID VALIDO",
                    '$_GET' => $_GET,
                    '$_POST' => $_POST
                ];
    echo json_encode($respuesta);
}

?>