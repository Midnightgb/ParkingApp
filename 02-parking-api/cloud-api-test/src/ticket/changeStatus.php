<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['id']) && !empty($_POST['status'])) {

    $id = $_POST['id'];
    $status = $_POST['status'];

    


    try {
        if($status == "activo"){
            $query = "UPDATE ticket SET status = 'inactivo' WHERE id = :d";
        }else{
            $query = "UPDATE ticket SET status = 'activo' WHERE id = :d";
        }
        
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':d', $id);


        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "Ticket actualizado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "Error al actualizar el ticket"
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