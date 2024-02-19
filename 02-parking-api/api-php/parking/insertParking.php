<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['name']) and !empty($_POST['address'])) {

    $name = $_POST['name'];
    $address = $_POST['address'];
    $camioneta = $_POST['camioneta'];
    $camion = $_POST['camion'];
    $carro = $_POST['carro'];
    $moto = $_POST['moto'];

    try {
        $query = "INSERT INTO parking (name, address, camioneta, camion, carro, moto) VALUES (:nm, :ad, :cmt, :cmo, :cr, :mt)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':nme', $name);
        $consulta->bindParam(':ad', $address);
        $consulta->bindParam(':cmt', $camioneta);
        $consulta->bindParam(':cmo', $camion);
        $consulta->bindParam(':cr', $carro);
        $consulta->bindParam(':mt', $moto);
        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "Parqueadero registrado correctamente"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##SQL"
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