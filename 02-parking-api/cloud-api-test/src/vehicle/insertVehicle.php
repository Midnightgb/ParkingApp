<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['plate']) && !empty($_POST['category']) && !empty($_POST['owner'])) {

    $plate = $_POST['plate'];
    $category = $_POST['category'];
    $owner = $_POST['owner'];

    try {
        $query = "INSERT INTO public.vehicle (plate, category, name_owner) VALUES (:plt, :ctid, :owr)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':plt', $plate);
        $consulta->bindParam(':ctid', $category);
        $consulta->bindParam(':owr', $owner);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => "Vehiculo insertado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "No se pudo insertar el vehiculo"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'message' => "ERROR##SQL",
            'exception' => $e->getMessage()
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'message' => "Uno o mas campos estan vacios"
    ];
    echo json_encode($respuesta);
}
?>
