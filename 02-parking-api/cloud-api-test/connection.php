<?php
$server = 'aws-0-us-west-1.pooler.supabase.com';
$user = 'postgres.jvxmpvbcszmmarqfhhll';
$pass = 'pEM99xFtQpx4vLd7';
$dbName = 'postgres';
$port = 5432;
/* user=postgres.jvxmpvbcszmmarqfhhll password=[YOUR-PASSWORD] host=aws-0-us-west-1.pooler.supabase.com port=5432 dbname=postgres */
try{
   $DB = new PDO("pgsql:host=$server;port=$port;dbname=$dbName;user=$user;password=$pass");
   error_log("conectado a la base de datos parking");
}catch(Exception $e){
   error_log($e->getMessage());
   echo 'Ha surgido un error y no se puede conectar a la base de datos. Detalle: ' . $e->getMessage();
   exit;
}
