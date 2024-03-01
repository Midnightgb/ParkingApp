<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include '../connection.php';

if (!empty($_POST['id']) and !empty($_POST['date'])) {


    try {
        $id = $_POST['id'];
        $date = $_POST['date'];
        try {
            // Obtener la hora de entrada del ticket
            $query = "SELECT entry_date FROM public.ticket WHERE id = :id";
            $stmt = $DB->prepare($query);
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            $stmt->execute();
            $entry_time = $stmt->fetchColumn();

            // Obtener la categoría del vehículo del ticket
            $query = "SELECT v.category FROM public.ticket AS t INNER JOIN public.vehicle AS v ON t.plate = v.plate WHERE t.id = :id";
            $stmt = $DB->prepare($query);
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            $stmt->execute();
            $veh_category = $stmt->fetchColumn();

            // Obtener la tarifa por hora para la categoría de vehículo desde la tabla 'parking'
            $query = "SELECT " . $veh_category . " FROM public.parking WHERE id = (SELECT parking_id FROM public.parking_seller WHERE id_parking_seller = (SELECT parking_id FROM public.ticket WHERE id = :id))";
            $stmt = $DB->prepare($query);
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            $stmt->execute();
            $vehicle_rate = $stmt->fetchColumn();

            // Calcular el costo total en función de la diferencia entre la hora de entrada y la hora de salida personalizada
            $total_cost = ceil((strtotime($date) - strtotime($entry_time)) / 3600) * $vehicle_rate;

            // Actualizar la hora de salida y el campo 'total' en la tabla 'ticket'
            $query = "UPDATE public.ticket SET exit_date = :date, total = :total_cost WHERE id = :id";
            $stmt = $DB->prepare($query);
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            $stmt->bindParam(':date', $date, PDO::PARAM_STR);
            $stmt->bindParam(':total_cost', $total_cost, PDO::PARAM_STR);
            $stmt->execute();
        } catch (Exception $e) {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##SQL",
                'exception' => $e
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
        'mesagge' => "ERROR##PARAMS"
    ];
    echo json_encode($respuesta);
}
?>
```