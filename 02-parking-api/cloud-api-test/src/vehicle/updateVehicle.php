<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['plate']) && !empty($_POST['category'])) {

    $plate = $_POST['plate'];
    $category = $_POST['category'];
    $owner = $_POST['owner'];

    try {
        
        $query = "UPDATE public.vehicle SET category = :ctid, name_owner = :ownr WHERE plate = :plt";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':ctid', $category);
        $consulta->bindParam(':plt', $plate);
        $consulta->bindParam(':ownr', $owner);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => "Vehiculo actualizado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "No se pudo actualizar el vehiculo"
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
