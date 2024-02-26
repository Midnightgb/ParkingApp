<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['id']) and !empty($_POST['date'])) {


    try {
        $id = $_POST['id'];
        $date = $_POST['date'];
        $query = "CALL CalculateTicketTotalWithCustomExitTimeAndExitDate(:id2, :date1)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':id2', $id, PDO::PARAM_INT);
        $consulta->bindParam(':date1', $date, PDO::PARAM_STR);


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