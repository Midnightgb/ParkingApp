<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['id']) and !empty($_POST['name'])) {

    $id = $_POST['id'];
    $name = $_POST['name'];
    $address = $_POST['address'];
    $camioneta = $_POST['camioneta'];
    $camion = $_POST['camion'];
    $carro = $_POST['carro'];
    $moto = $_POST['moto'];
    $status = $_POST['status'];
    


    try {
        $query = "UPDATE parking SET name = :nm, address = :ad, camioneta = :cmt, camion = :cmo, carro = :cr, moto = :mt, status = :sts WHERE id = :d";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':d', $id);
        $consulta->bindParam(':nm', $name);
        $consulta->bindParam(':ad', $address);
        $consulta->bindParam(':cmt', $camioneta);
        $consulta->bindParam(':cmo', $camion);
        $consulta->bindParam(':cr', $carro);
        $consulta->bindParam(':mt', $moto);
        $consulta->bindParam(':sts', $status);


        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "<html>Parqueadero actualizado correctamente<html>"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "<html>Error al actualizar el parqueadero<html>"
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
        'mesagge' => "<html>Uno o más campos están vacíos<html>"
    ];
    echo json_encode($respuesta);
}

?>