<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['iduser'])) {

    $id = $_POST['iduser'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $hashed_password = password_hash($password, PASSWORD_BCRYPT);
    $rol = $_POST['rol'];

    try {
        $query = "SELECT * FROM user WHERE id = :idsr";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':idsr', $id);
        if ($consulta->execute()) {
            $datos = $consulta->fetchAll(PDO::FETCH_ASSOC);
            if (sizeof($datos) > 0) {
                $respuesta = [
                    'status' => false,
                    'mesagge' => "El usuario ya existe"
                ];
                echo json_encode($respuesta);
                exit;
            }
        }

        $query = "INSERT INTO user (id, name, email, password, rol) VALUES (:idsr, :usrne, :eml, :pswrd, :rl)";
        $consulta = $DB->prepare($query);
        $consulta->bindParam(':idsr', $id);
        $consulta->bindParam(':usrne', $name);
        $consulta->bindParam(':eml', $email);
        $consulta->bindParam(':pswrd', $hashed_password);
        $consulta->bindParam(':rl', $rol);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "Usuario Agregado"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "Error al agregar usuario"
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
        'mesagge' => "Debe ingresar la cedula del usuario"
    ];
    echo json_encode($respuesta);
}
  
?>