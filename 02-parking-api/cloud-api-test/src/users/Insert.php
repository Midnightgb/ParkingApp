<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

if (!empty($_POST['iduser']) || !empty($_GET['iduser'])) {

    $id = isset($_POST['iduser']) ? $_POST['iduser'] : (isset($_GET['iduser']) ? $_GET['iduser'] : null);
    $name = isset($_POST['name']) ? $_POST['name'] : (isset($_GET['name']) ? $_GET['name'] : null);
    $email = isset($_POST['email']) ? $_POST['email'] : (isset($_GET['email']) ? $_GET['email'] : null);
    $password = isset($_POST['password']) ? $_POST['password'] : (isset($_GET['password']) ? $_GET['password'] : null);
    $hashed_password = password_hash($password, PASSWORD_BCRYPT);
    $rol = isset($_POST['rol']) ? $_POST['rol'] : (isset($_GET['rol']) ? $_GET['rol'] : null);

    try {
        $query = "SELECT * FROM public.user WHERE id = :idsr";
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

        $query = "INSERT INTO public.user (id, name, email, password, rol) VALUES (:idsr, :usrne, :eml, :pswrd, :rl)";
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