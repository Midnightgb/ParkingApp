<?php
header("Access-Control-Allow-Origin: * ");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_GET['iduser'])) {
    $iduser = $_GET['iduser'];
    $consulta = $DB->prepare("SELECT * FROM user WHERE id = :idsr");
    $consulta->bindParam(':idsr', $iduser);
    $consulta->execute();
    $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);


    if (empty($datos)) {
        $respuesta = [
            'status' => false,
            'message' => "<html>Cedula no registrada<html>",
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
        return;
    }

    // verificar si el usuario es admin o seller para obtener el parking_id correspondiente al usuario
    $role = $datos[0]['rol'];
    if ($role != "admin") {
        $consulta = $DB->prepare("SELECT parking_id FROM parking_seller WHERE user_id = :idsr");
        $consulta->bindParam(':idsr', $iduser);
        $consulta->execute();
        $parking_id = $consulta->fetchAll(PDO::FETCH_ASSOC);

        // verificar si el usuario tiene un parqueadero asignado
        if (sizeof($parking_id) > 0) {
            $parking_id = $parking_id[0]['parking_id'];
            // verificar si el parqueadero asignado al usuario esta activo
            $consulta = $DB->prepare("SELECT * FROM parking WHERE id = :idsr");
            $consulta->bindParam(':idsr', $parking_id);
            $consulta->execute();
            $status = $consulta->fetchAll(PDO::FETCH_ASSOC);
            if ($status[0]['status'] != "activo") {
                $respuesta = [
                    'status' => false,
                    'message' => "<html>El parqueadero asignado al usuario no esta activo<html>",
                    '$_GET' => $_GET,
                    '$_POST' => $_POST
                ];
                echo json_encode($respuesta);
                return;
            }
        } else {
            $respuesta = [
                'status' => false,
                'message' => "<html>El usuario no tiene un parqueadero asignado<html>",
                '$_GET' => $_GET,
                '$_POST' => $_POST
            ];
            echo json_encode($respuesta);
            return;
        }
    } else {
        $parking_id = "admin";
    }
    // settear el parking_id en el array de datos
    $datos[0]['parking_id'] = $parking_id;

    if (!empty($_GET['validatePass'])) {
        $passToValidate = $_GET['validatePass'];
        $passToValidate = password_verify($passToValidate, $datos[0]['password']);
        error_log("passToValidate: " . $passToValidate);
        if ($passToValidate) {
            $datos[0]['password'] = "OK";
        } else {
            $datos[0]['password'] = "Contraseña incorrecta";
        }
    } else {
        $datos[0]['password'] = "pillin";
    }

    if (sizeof($datos) > 0) {
        $respuesta = [
            'status' => true,
            'message' => "OK##DATOS##GET",
            'datos' => $datos[0]
        ];
    } else {
        $respuesta = [
            'status' => false,
            'message' => "<html>Cedula no registrada<html>",
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
    }
    echo json_encode($respuesta);
} else {
    $respuesta = [
        'status' => false,
        'message' => "<html>Debe enviar la cedula del usuario<html>",
        '$_GET' => $_GET,
        '$_POST' => $_POST
    ];
    echo json_encode($respuesta);
}
?>