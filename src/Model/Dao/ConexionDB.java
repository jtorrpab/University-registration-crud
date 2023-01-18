package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    
    private Connection conexion;
    private String URL = "jdbc:sqlite:DBUniversidad";

    public ConexionDB(){

        try {
            conexion = DriverManager.getConnection(URL);
            if(conexion != null){
                System.out.println("Inicio de conexión a la Base de datos DBUniversidad");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion(){
        return conexion;
    }

    public void CloseConexion(){
        try {
            if(conexion != null){
                if(conexion.isClosed()){
                    System.out.println("Conexión finalizada a la base de datos DBUniversidad");
                }else{
                    conexion.close();
                    System.out.println("Conexión finalizada a la base de datos DBUniversidad");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
