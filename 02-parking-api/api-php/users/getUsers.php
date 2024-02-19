<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

$query = $DB->query("SELECT * FROM user");
$data = $query->fetchAll(PDO::FETCH_ASSOC);

$response['users'] = $data;
echo json_encode($response);
?>