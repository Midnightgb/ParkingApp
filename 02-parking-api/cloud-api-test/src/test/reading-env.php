<?php
header("Access-Control-Allow-Origin: * ");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

// Acceder a la variable de entorno
$server = getenv('SERVER');
$user = getenv('USER');
$pass = getenv('PASS');
$dbName = getenv('DBNAME');
$port = getenv('DBPORT');

// Crear un arreglo con los valores
$database_url = [
    'server' => $server,
    'user' => $user,
    'pass' => $pass,
    'dbName' => $dbName,
    'port' => $port
];
// Utilizar el valor
echo json_encode($database_url);
?>
