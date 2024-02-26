<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

$query = $DB->query("SELECT t.*, p.name AS parking_name FROM ticket t JOIN parking_seller ps ON t.parking_id = ps.id_parking_seller JOIN parking p ON ps.parking_id = p.id");
$data = $query->fetchAll(PDO::FETCH_ASSOC);

$response['tickets'] = $data;
echo json_encode($response);
?>