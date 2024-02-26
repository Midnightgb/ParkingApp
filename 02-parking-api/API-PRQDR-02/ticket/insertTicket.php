<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['parking_id']) and !empty($_POST['plate'])) {

    $parking_id = $_POST['parking_id'];
    $plate = $_POST['plate'];

    try {
        $query = "INSERT INTO ticket ( parking_id, plate) VALUES (:pargid, :plte)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':pargid', $parking_id);
        $consulta->bindParam(':plte', $plate);


        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "Ticket registrado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "Error al registrar el ticket"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##SQL",
            'exception' => $e
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'mesagge' => "Uno o más campos están vacíos"
    ];
    echo json_encode($respuesta);
}
  
?>