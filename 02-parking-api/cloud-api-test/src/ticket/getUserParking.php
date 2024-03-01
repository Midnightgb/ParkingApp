<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

$query = $DB->query("SELECT ps.*,u.*,p.* FROM public.user u JOIN public.parking_seller ps ON u.id = ps.user_id JOIN public.parking p ON ps.parking_id = p.id");
$data = $query->fetchAll(PDO::FETCH_ASSOC);

$response['userParking'] = $data;
echo json_encode($response);
?>