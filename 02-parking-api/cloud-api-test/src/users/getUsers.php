<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
header("Content-Type: application/json");

include '../connection.php';

$query = $DB->query("SELECT * FROM public.user");
$data = $query->fetchAll(PDO::FETCH_ASSOC);

$response['users'] = $data;
foreach ($data as $key => $value) {
    $response['users'][$key]['id'] = $value['id'];
    $response['users'][$key]['name'] = $value['name'];
    $response['users'][$key]['email'] = $value['email'];
    $response['users'][$key]['password'] = "********";
    $response['users'][$key]['rol'] = $value['rol'];
    $response['users'][$key]['status'] = $value['status'];
}
echo json_encode($response);
?>