package parkingAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.ResultSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ApiParqueaderoApplication {
    DataBase db;

    public ApiParqueaderoApplication() {
        db = new DataBase();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiParqueaderoApplication.class, args);
    }

    @GetMapping("/parkingAPI/vehicle/getVehicles")
    public ObjectNode listavehiculos() {
        List < Vehicle > vehicles = new ArrayList < > ();
        ResultSet consulta = db.consltarVehicles();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta != null) {
            try {
                do {
                    String plate = consulta.getString("plate");
                    String name_owner = consulta.getString("name_owner");
                    String category = consulta.getString("category");

                    Vehicle temporal = new Vehicle(plate, name_owner, category);
                    vehicles.add(temporal);
                } while (consulta.next());
                response.put("status", true);
                response.put("message", "OK##DATOS##GET");
                response.set("vehicles", objectMapper.valueToTree(vehicles));
            } catch (Exception e) {
                System.out.println("Error en extraccion de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "Error al consultar vehiculos");
            }

        } else {
            response.put("status", false);
            response.put("message", "No hay vehiculos");
        }

        return response;

    }

    @GetMapping("/parkingAPI/vehicle/getVehicle")
    public ObjectNode getVehicle(@RequestParam String plate) {
        ResultSet consulta = db.consultarVehiculo(plate);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta != null) {
            try {
                String name_owner = consulta.getString("name_owner");
                String category = consulta.getString("category");

                Vehicle temporal = new Vehicle(plate, name_owner, category);

                response.put("status", true);
                response.put("message", "OK##DATOS##GET");
                response.set("datos", objectMapper.valueToTree(temporal));
            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "No se encontro");
            }
        } else {
            response.put("status", false);
            response.put("message", "No se encontro");
        }

        return response;
    }

    @PostMapping("/parkingAPI/vehicle/insertVehicle")
    public ObjectNode insertarVehicle(@RequestParam("plate") String plate, @RequestParam("owner") String name_owner, @RequestParam("category") String category) {
        boolean consulta = db.insertVehicle(plate, name_owner, category);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta) {
            try {

                response.put("status", true);
                response.put("message", "SE INSERTO CORRECTAMENTE");

            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "No se pudo insertar");
            }
        } else {
            response.put("status", false);
            response.put("message", "No se pudo insertar");
        }

        return response;
    }

    @PostMapping("/parkingAPI/vehicle/updateVehicle")
    public ObjectNode updateVehicle(@RequestParam("plate") String plate, @RequestParam("owner") String name_owner, @RequestParam("category") String category) {
        boolean consulta = db.updateVehicle(plate, name_owner, category);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta) {
            try {

                response.put("status", true);
                response.put("message", "SE ACTUALIZO CORRECTAMENTE");

            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "No se pudo actualizar");
            }
        } else {
            response.put("status", false);
            response.put("message", "No se pudo actualizar");
        }

        return response;

    }


    @GetMapping("/parkingAPI/parking/getParkings")
    public ObjectNode listParkings() {
        List < Parking > parkings = new ArrayList < > ();
        ResultSet consulta = db.consltarParqueaderos();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta != null) {
            try {
                do {
                    int id = consulta.getInt("id");
                    String name = consulta.getString("name");
                    String address = consulta.getString("address");

                    int camioneta = consulta.getInt("camioneta");
                    int camion = consulta.getInt("camion");
                    int carro = consulta.getInt("carro");
                    int moto = consulta.getInt("moto");
                    String status = consulta.getString("status");
                    System.out.println(status);

                    Parking temporal = new Parking(id, name, address, camioneta, camion, carro, moto, status);
                    parkings.add(temporal);

                } while (consulta.next());
                response.put("status", true);
                response.put("message", "OK##DATOS##GET");
                response.set("parkings", objectMapper.valueToTree(parkings));
            } catch (Exception e) {
                System.out.println("Error en extraccion de datos: " + e.getMessage());


                response.put("status", false);
                response.put("message", "Error al consultar parqueaderos");
            }

        } else {
            response.put("status", false);
            response.put("message", "No hay parqueaderos");
        }

        return response;

    }


    @GetMapping("/parkingAPI/parking/getParking")
    public ObjectNode getParking(@RequestParam String id_p) {
        int id_par = Integer.parseInt(id_p);
        ResultSet consulta = db.consultarParqueadero(id_par);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta != null) {
            try {
                int id = consulta.getInt("id");
                String name = consulta.getString("name");
                String address = consulta.getString("address");
                int camioneta = consulta.getInt("camioneta");
                int camion = consulta.getInt("camion");
                int carro = consulta.getInt("carro");
                int moto = consulta.getInt("moto");
                String status = consulta.getString("status");

                Parking temporal = new Parking(id, name, address, camioneta, camion, carro, moto, status);


                response.put("status", true);
                response.put("message", "OK##DATOS##GET");
                response.set("datos", objectMapper.valueToTree(temporal));
            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "No se encontro");
            }
        } else {
            response.put("status", false);
            response.put("message", "No se encontro");
        }

        return response;
    }

    @PostMapping("/parkingAPI/parking/insertParking")
    public ObjectNode insertarParking(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("camioneta") int camioneta, @RequestParam("camion") int camion, @RequestParam("carro") int carro, @RequestParam("moto") int moto) {
        boolean consulta = db.insertParking(name, address, camioneta, camion, carro, moto);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta) {
            try {

                response.put("status", true);
                response.put("mesagge", "SE INSERTO CORRECTAMENTE");

            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("mesagge", "No se pudo insertar");
            }
        } else {
            response.put("status", false);
            response.put("mesagge", "No se pudo insertar");
        }

        return response;
    }

    @PostMapping("/parkingAPI/parking/updateParking")
    public ObjectNode updateParking(@RequestParam("id") String id_p, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("camioneta") String camioneta, @RequestParam("camion") String camion, @RequestParam("carro") String carro, @RequestParam("moto") String moto, @RequestParam("status") String sattus) {
        int id = Integer.parseInt(id_p);
        int camionetaa = Integer.parseInt(camioneta);
        int camionn = Integer.parseInt(camion);
        int carroo = Integer.parseInt(carro);
        int motoo = Integer.parseInt(moto);

        boolean consulta = db.updateParking(id, name, address, camionetaa, camionn, carroo, motoo, sattus);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();

        if (consulta) {
            try {

                response.put("status", true);
                response.put("mesagge", "SE ACTUALIZO CORRECTAMENTE");

            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("mesagge", "No se pudo actualizar");
            }
        } else {
            response.put("status", false);
            response.put("mesagge", "No se pudo actualizar");
        }

        return response;

    }

    @GetMapping("/parkingAPI/users/getUser")
    public ObjectNode getUser(@RequestParam("iduser") int iduser, @RequestParam(value = "validatePass", required = false) String validatePass) {
        ObjectNode response = new ObjectMapper().createObjectNode();
        String password = "NONAS";
        try {
            ResultSet userData = db.getUser(iduser);
            System.out.println("userdata: " + userData.getString("name"));
            if (userData != null) {
                //validacion de contraseña encriptada
                if (validatePass != null) {
                    password = "OK";
                }
                //validacion de rol
                if (!userData.getString("rol").equals("admin")) {
                    System.out.println("obtencion del parqueadero al que pertenece el usuario");
                    ResultSet parkingID = db.getParkingUser(iduser);
                    System.out.println(parkingID);
                    System.out.println("parkingID: " + parkingID.getString("parking_id"));
                    //validacion de parqueadero
                    if (parkingID != null) {
                        ResultSet parkingData = db.consultarParqueadero(parkingID.getInt("parking_id"));
                        System.out.println("parkingData: " + parkingData.getString("name"));
                        //validacion de estado de parqueadero
                        if (parkingData.getString("status").equals("inactivo")) {
                            response.put("status", false);
                            response.put("message", "<html>El parqueadero asignado al usuario no esta activo<html>");
                            return response;
                        }
                        //retornar datos de usuario
                        User user = new User(userData.getInt("id"), userData.getString("name"), userData.getString("email"), userData.getString("rol"), userData.getString("status"), parkingID.getString("parking_id"), password);
                        response.put("status", true);
                        response.put("message", "OK##DATOS##GET");
                        response.set("datos", new ObjectMapper().valueToTree(user));
                        return response;
                    }
                    response.put("status", false);
                    response.put("message", "<html>El usuario no tiene parqueadero asignado<html>");
                    return response;
                } else {
                    System.out.println("es admin");
                    User user = new User(userData.getInt("id"), userData.getString("name"), userData.getString("email"), userData.getString("rol"), userData.getString("status"), "admin", password);
                    response.put("status", true);
                    response.put("message", "OK##DATOS##GET");
                    response.set("datos", new ObjectMapper().valueToTree(user));
                    return response;
                }
            }
            response.put("status", false);
            response.put("message", "<html>Cedula no registrada<html>");
            return response;
        } catch (Exception e) {
            System.out.println("Error en extracción de datos: " + e.getMessage());
            response.put("status", false);
            response.put("message", "Error al consultar usuario");
            return response;
        }
    }

    @GetMapping("/parkingAPI/users/getUsers")
    public ObjectNode getUsers() {
        List < User > users = new ArrayList < > ();
        ResultSet consulta = db.getUsers();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        if (consulta != null) {
            try {
                do {
                    int id = consulta.getInt("id");
                    String nombre = consulta.getString("name");
                    String correo = consulta.getString("email");
                    String rol = consulta.getString("rol");
                    String estado = consulta.getString("status");
                    String parking = "0";
                    User temporal = new User(id, nombre, correo, rol, estado, parking, "NONAS");
                    users.add(temporal);
                } while (consulta.next());
                response.put("status", true);
                response.put("message", "OK##DATOS##GET");
                response.set("users", objectMapper.valueToTree(users));
            } catch (Exception e) {
                System.out.println("Error en extraccion de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "Error al consultar usuarios");
            }
        } else {
            response.put("status", false);
            response.put("message", "No hay usuarios");
        }
        return response;
    }
    
    @PostMapping("/parkingAPI/users/insertUser")
    public ObjectNode insertUser(
        @RequestParam("iduser") String iduser, 
        @RequestParam("name") String name, 
        @RequestParam("email") String email, 
        @RequestParam("password") String password, 
        @RequestParam("rol") String role) {
        boolean consulta = db.insertUser(iduser, name, email, password, role);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        System.out.println("consulta: " + consulta);
        if (consulta) {
            try {
                response.put("status", true);
                response.put("mesagge", "SE INSERTO CORRECTAMENTE");
            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("mesagge", "No se pudo insertar");
            }
        } else {
            response.put("status", false);
            response.put("mesagge", "No se pudo insertar");
        }
        return response;
    }

    @PostMapping("/parkingAPI/users/Update")
    public ObjectNode updateUser(
        @RequestParam("iduser") String iduser, 
        @RequestParam("name") String name, 
        @RequestParam("email") String email, 
        @RequestParam(value = "action", required = false) String action, 
        @RequestParam(value = "password", required = false) String password , 
        @RequestParam("rol") String role,
        @RequestParam("status") String status){
        
        System.out.println("iduser: " + iduser + " name: " + name + " email: " + email + " action: " + action + " password: " + password + " role: " + role + " status: " + status);
        //boolean consulta = db.updateUser(iduser, name, email, action, password, role, status);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        //System.out.println("consulta: " + consulta);
 /*        if (consulta) {
            try {
                response.put("status", true);
                response.put("message", "SE ACTUALIZO CORRECTAMENTE");
            } catch (Exception e) {
                System.out.println("Error en extracción de datos: " + e.getMessage());
                response.put("status", false);
                response.put("message", "No se pudo actualizar");
            }
        } else {
            response.put("status", false);
            response.put("message", "No se pudo actualizar");
        } */
        return response;
    }

}