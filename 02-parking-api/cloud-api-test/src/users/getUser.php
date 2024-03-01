<?php
header("Access-Control-Allow-Origin: * ");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['iduser']) || !empty($_POST['email']) || !empty($_GET['iduser']) || !empty($_GET['email'])){
    if (!empty($_POST['iduser']) || !empty($_GET['iduser'])) {
        $iduser = isset($_POST['iduser']) ? $_POST['iduser'] : (isset($_GET['iduser']) ? $_GET['iduser'] : null);
        $consulta = $DB->prepare("SELECT * FROM public.user WHERE id = :idusr");
        $consulta->bindParam(':idusr', $iduser);
        $consulta->execute();
        $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
        if (empty($datos)) {
            $respuesta = [
                'status' => false,
                'message' => "<html>Cedula no registrada<html>",
                '$_POST' => $_POST,
            ];
            echo json_encode($respuesta);
            return;
        }
        $email = $datos[0]['email'];
    }

    if (!empty($_POST['email']) || !empty($_GET['email'])) {
        $email = isset($_POST['email']) ? $_POST['email'] : (isset($_GET['email']) ? $_GET['email'] : null);
        $consulta = $DB->prepare("SELECT * FROM public.user WHERE email = :emusr");
        $consulta->bindParam(':emusr', $email);
        $consulta->execute();
        $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
        if (empty($datos)) {
            $respuesta = [
                'status' => false,
                'message' => "<html>Cedula no registrada<html>",
                '$_POST' => $_POST,
            ];
            echo json_encode($respuesta);
            return;
        }
        $iduser = $datos[0]['id'];
    }

    // verificar si el usuario es admin o seller para obtener el parking_id correspondiente al usuario
    $role = $datos[0]['rol'];

    if ($role != "admin") {
        $consulta = $DB->prepare("SELECT parking_id FROM public.parking_seller WHERE user_id = :idsr");
        $consulta->bindParam(':idsr', $iduser);
        $consulta->execute();
        $parking_id = $consulta->fetchAll(PDO::FETCH_ASSOC);

        // verificar si el usuario tiene un parqueadero asignado
        if (sizeof($parking_id) > 0) {
            $parking_id = $parking_id[0]['parking_id'];

            // verificar si el parqueadero asignado al usuario está activo
            $consulta = $DB->prepare("SELECT * FROM public.parking WHERE id = :idsr AND status = 'activo'");
            $consulta->bindParam(':idsr', $parking_id);
            $consulta->execute();

            if (!$consulta->fetch(PDO::FETCH_ASSOC)) {
                $respuesta = [
                    'status' => false,
                    'message' => "<html>El parqueadero asignado al usuario no está activo<html>",
                    '$_POST' => $_POST,
                ];
                echo json_encode($respuesta);
                return;
            }
        } else {
            $respuesta = [
                'status' => false,
                'message' => "<html>El usuario no tiene un parqueadero asignado<html>",
                '$_POST' => $_POST,
            ];
            echo json_encode($respuesta);
            return;
        }
    } else {
        $parking_id = "admin";
    }

    // setear el parking_id en el array de datos
    $datos[0]['parking_id'] = $parking_id;

    if (!empty($_POST['validatePass']) || !empty($_GET['validatePass'])) {
        $passToValidate = isset($_POST['validatePass']) ? $_POST['validatePass'] : (isset($_GET['validatePass']) ? $_GET['validatePass'] : null);
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
            '$_POST' => $_POST,
        ];
    }
    echo json_encode($respuesta);
} else {
    $respuesta = [
        'status' => false,
        'message' => "<html>Debe enviar la cedula del usuario<html>",
        '$_POST' => $_POST,
    ];
    echo json_encode($respuesta);
}
