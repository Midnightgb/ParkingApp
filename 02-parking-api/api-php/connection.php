<?php
$server = 'localhost';
$user = 'root';
$pass = '';
$dbName = 'parking';

try{
   $DB = new PDO("mysql:host=$server;dbname=$dbName", $user, $pass);
   error_log("conectado a la base de datos parking");
}catch(Exception $e){
   error_log($e->getMessage());
   echo 'Ha surgido un error y no se puede conectar a la base de datos. Detalle: ' . $e->getMessage();
   exit;
}
