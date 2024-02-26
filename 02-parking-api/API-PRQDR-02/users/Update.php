<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['iduser'])) {

    $id = $_POST['iduser'];
    $name = !empty($_POST['name']) ? $_POST['name'] : "";
    $email = !empty($_POST['email']) ? $_POST['email'] : "";
    
    if(!empty($_POST['password'])){
        $password = $_POST['password'];
    }

    if(!empty($_POST['action'])){
        $action = $_POST['action'];
        if ($action == "updatePassword"){
            $password = $_POST['password'];
            try{
                $hashed_password = password_hash($password, PASSWORD_BCRYPT);
                $query_update_user = "UPDATE user SET password = :pswrd WHERE id = :idsr";
                $consulta_update_user = $DB->prepare($query_update_user);
                $consulta_update_user->bindParam(':idsr', $id);
                $consulta_update_user->bindParam(':pswrd', $hashed_password);
                $proceso = $consulta_update_user->execute();
                if ($proceso) {
                    $respuesta = [
                        'status' => true,
                        'message' => "Contraseña Actualizada"
                    ];
                    echo json_encode($respuesta);
                } else {
                    $respuesta = [
                        'status' => false,
                        'message' => "Error al actualizar contraseña"
                    ];
                    echo json_encode($respuesta);
                }
            } catch (Exception $e) {
                $respuesta = [
                    'status' => false,
                    'message' => "ERROR##SQL",
                    'exception' => $e
                ];
                echo json_encode($respuesta);
            }
            exit;
        }
    }

    
    $rol = $_POST['rol'];
    $status = $_POST['status'];

    try {
        // Consulta para verificar si el usuario existe
        $query_check_user = "SELECT * FROM user WHERE id = :idsr";
        $consulta_check_user = $DB->prepare($query_check_user);
        $consulta_check_user->bindParam(':idsr', $id);
        $consulta_check_user->execute();

        if ($consulta_check_user->rowCount() === 0) {
            // El usuario no existe
            $respuesta = [
                'status' => false,
                'message' => "El usuario no existe"
            ];
            echo json_encode($respuesta);
            exit;
        }

        if (!empty($password)) {
            $hashed_password = password_hash($password, PASSWORD_BCRYPT);
            $query_update_user = "UPDATE user SET name = :cstne, email = :eml, password = :pswrd, rol = :rl, status = :sts WHERE id = :idsr";
        } else{
            $query_update_user = "UPDATE user SET name = :cstne, email = :eml, rol = :rl, status = :sts WHERE id = :idsr";
        }
        // El usuario existe, procedemos a actualizarlo
        $consulta_update_user = $DB->prepare($query_update_user);
        $consulta_update_user->bindParam(':idsr', $id);
        $consulta_update_user->bindParam(':cstne', $name);
        $consulta_update_user->bindParam(':eml', $email);
        if (!empty($password)) {
            $consulta_update_user->bindParam(':pswrd', $hashed_password);
        }
        $consulta_update_user->bindParam(':rl', $rol);
        $consulta_update_user->bindParam(':sts', $status);
        $proceso = $consulta_update_user->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => "Usuario Actualizado"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "Error al actualizar usuario"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'message' => "ERROR##SQL",
            'exception' => $e
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'message' => "Ingresa la cedula"
    ];
    echo json_encode($respuesta);
}
?>
