<?php
$server = getenv('SERVER');
$user = getenv('USER');
$pass = getenv('PASS');
$dbName = getenv('DBNAME');
$port = getenv('DBPORT');
try{
   $DB = new PDO("pgsql:host=$server;port=$port;dbname=$dbName;user=$user;password=$pass");
   error_log("conectado a la base de datos parking");
}catch(Exception $e){
   error_log($e->getMessage());
   $message = "No se puede conectar a la base de datos. " . $e->getMessage();
   $response = [
      'status' => false,
      'message' => $message
   ];
   echo json_encode($response);
   exit;
}
