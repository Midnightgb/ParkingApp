package parkingAPI;

import java.sql.*;

public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "localhost";
        String puerto = "3306";
        String user_name = "root";
        String password = "";
        String database_name = "parking";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try {
            this.conexion = DriverManager.getConnection(url, user_name, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.println("Conexion a DataBase Exitosa.");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a base de dato: "+ex.getMessage());
        }
    }
    //vehicles
    public ResultSet consltarVehicles(){
        try {
            String consulta = "SELECT * FROM vehicle";
            ResultSet resultado = manipularDB.executeQuery(consulta);
            resultado.next();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al obtener vehiculos: " + ex.getMessage());
            return null;
        }
    }
    
    public ResultSet consultarVehiculo(String plate) {
        try {
            String consulta = "SELECT * FROM vehicle WHERE plate = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1,    plate);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
               return resultado;
            } else {
                return null; 
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar vehículo por placa: " + ex.getMessage());
            return null;
        }
        
    }
    
    public boolean insertVehicle(String plate, String name_owner, String category){
        boolean resultado = false;
        try {
            String insert = "INSERT INTO vehicle (plate, name_owner,category) VALUES (?, ?, ?)";
            PreparedStatement consultaPreparada = conexion.prepareStatement(insert);
            consultaPreparada.setString(1, plate);
            consultaPreparada.setString(2, name_owner);
            consultaPreparada.setString(3, category);

            int respuesta = consultaPreparada.executeUpdate();

            if (respuesta > 0) {
                resultado = true;
            }
            return resultado;

        } catch (SQLException ex) {
            System.out.println("Error en la inserción: " + ex.getMessage());
            return resultado;
        }
    }
    
    public boolean updateVehicle(String plate, String name_owner, String category){
        boolean resultado = false;
        try {
            String insert = "UPDATE vehicle SET  name_owner = ? , category = ?WHERE plate = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(insert);
            
            consultaPreparada.setString(1, name_owner);
            consultaPreparada.setString(2, category);
            consultaPreparada.setString(3, plate);

            int respuesta = consultaPreparada.executeUpdate();

            if (respuesta > 0) {
                resultado = true;
            }
            return resultado;

        } catch (SQLException ex) {
            System.out.println("Error en la inserción: " + ex.getMessage());
            return resultado;
        }
    }
    
    //parkings
    public ResultSet consltarParqueaderos(){
        try {
            String consulta = "SELECT * FROM parking";
            ResultSet resultado = manipularDB.executeQuery(consulta);
            resultado.next();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al obtener vehiculos: " + ex.getMessage());
            return null;
        }
    }
    
    
    public ResultSet consultarParqueadero(int id) {
        try {
            String consulta = "SELECT * FROM parking WHERE  id = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1,    id);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
               return resultado;
            } else {
                return null; 
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar vehículo por placa: " + ex.getMessage());
            return null;
        }
        
    }
    
     public boolean insertParking(String name, String address,int camioneta, int camion, int carro,int moto ){
        boolean resultado = false;
        try {
            String insert = "INSERT INTO parking (name, address, camioneta, camion, carro, moto) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement consultaPreparada = conexion.prepareStatement(insert);
            consultaPreparada.setString(1, name);
            consultaPreparada.setString(2, address);
            consultaPreparada.setInt(3, camioneta);
            consultaPreparada.setInt(4, camion);
            consultaPreparada.setInt(5, carro);
            consultaPreparada.setInt(6, moto);
            
            
            int respuesta = consultaPreparada.executeUpdate();

            if (respuesta > 0) {
                resultado = true;
            }
            return resultado;

        } catch (SQLException ex) {
            System.out.println("Error en la inserción: " + ex.getMessage());
            return resultado;
        }
    }
     
     public boolean updateParking(int id,String name, String address,int camioneta, int camion, int carro,int moto ,String status){
        boolean resultado = false;
        try {
            String insert = "UPDATE parking SET name = ?, address = ?, camioneta = ?, camion = ?, carro = ?, moto = ?, status = ? WHERE id = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(insert);
            consultaPreparada.setString(1, name);
            consultaPreparada.setString(2, address);
            consultaPreparada.setInt(3, camioneta);
            consultaPreparada.setInt(4, camion);
            consultaPreparada.setInt(5, carro);
            consultaPreparada.setInt(6, moto);
            consultaPreparada.setString(7, status);
            consultaPreparada.setInt(8, id);
            
            
            int respuesta = consultaPreparada.executeUpdate();

            if (respuesta > 0) {
                resultado = true;
            }
            return resultado;

        } catch (SQLException ex) {
            System.out.println("Error en la inserción: " + ex.getMessage());
            return resultado;
        }
    }
    public ResultSet getUsers(){
        try {
            String consulta = "SELECT * FROM user";
            ResultSet resultado = manipularDB.executeQuery(consulta);
            resultado.next();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuarios: " + ex.getMessage());
            return null;
        }
    }
    
    public ResultSet getUser(int iduser){
        try {
            String consulta = "SELECT * FROM user WHERE id = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, iduser);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                return resultado;
            } else {
                return null; 
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario por id: " + ex.getMessage());
            return null;
        }
    }

    public ResultSet getParkingUser(int iduser){
        try {
            String consulta = "SELECT parking_id FROM parking_seller WHERE user_id = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, iduser);
            ResultSet resultado = consultaPreparada.executeQuery();
            if (resultado.next()) {
                return resultado;
            } else {
                return null; 
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar parking asociado al id: " + ex.getMessage());
            return null;
        }
    }

    public boolean insertUser(String idUser, String name, String email, String password, String role){
        boolean resultado = false;
        try {
            String consultar = "SELECT * FROM user WHERE id = ?";
            PreparedStatement consultaPreparada = conexion.prepareStatement(consultar);
            consultaPreparada.setString(1, idUser);
            ResultSet resultadoConsulta = consultaPreparada.executeQuery();
            if (resultadoConsulta.next()) {
                return false;
            }

            String insert = "INSERT INTO user (id, name, email, password, rol) VALUES (?, ?, ?, ?, ?)";
            consultaPreparada = conexion.prepareStatement(insert);
            consultaPreparada.setString(1, idUser);
            consultaPreparada.setString(2, name);
            consultaPreparada.setString(3, email);
            consultaPreparada.setString(4, password);
            consultaPreparada.setString(5, role);

            int respuesta = consultaPreparada.executeUpdate();

            if (respuesta > 0) {
                resultado = true;
            }
            return resultado;

        } catch (SQLException ex) {
            System.out.println("Error en la inserción: " + ex.getMessage());
            return resultado;
        }
    }

/*     public boolean updateUser(String idUser, String name, String email, String password, String role) {
        try {
            
        } catch (SQLException ex) {
            System.out.println("Error en la actualización del usuario: " + ex.getMessage());
        }
    
        return resultado;
    } */
    
}
