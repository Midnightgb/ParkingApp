<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['user_id']) and !empty($_POST['parking_id'])) {

    
    $parking_id = $_POST['parking_id'];
    $user_id = $_POST['user_id'];
    

    try {
        $query = "UPDATE public.parking_seller (parking_id, user_id) VALUES (:pargid, :usid)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':pargid', $parking_id);
        $consulta->bindParam(':usid', $user_id);
        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "Vendedor registrado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "Error al actualizar el vendedor"
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