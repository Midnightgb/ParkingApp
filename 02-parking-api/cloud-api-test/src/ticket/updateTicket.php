<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['id']) and !empty($_POST['parking_id'])) {

    $id = $_POST['id'];
    $parking_id = $_POST['parking_id'];
    $plate = $_POST['plate'];
    $exit_date = $_POST['exit_date'];
    $total = $_POST['total'];
    $status = $_POST['status'];

    


    try {
        $query = "UPDATE public.ticket SET parking_id = :pargid, plate = :plte, exit_date = :exdate, total = :toal, status = :stus WHERE id = :d";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':d', $id);
        $consulta->bindParam(':pargid', $parking_id);
        $consulta->bindParam(':plte', $plate);
        $consulta->bindParam(':exdate', $exit_date);
        $consulta->bindParam(':toal', $total);
        $consulta->bindParam(':stus', $status);


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