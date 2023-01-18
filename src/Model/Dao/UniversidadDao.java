package Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.Universidad;

public class UniversidadDao extends Universidad {

    public UniversidadDao(String nombre, String nit, String direccion, String email) {
        super(nombre, nit, direccion, email);
    }

    //#region Consultas SQL

    public boolean Insert(ConexionDB conexion){
        boolean insert = false;
        try {
            String query = "INSERT INTO universidades VALUES(?, ?, ?, ?)";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, getNit());
            pst.setString(2, getNombre());
            pst.setString(3, getDireccion());
            pst.setString(4, getEmail());
            insert = pst.executeUpdate() == 1 ? true : false;
            if(insert){
                System.out.println("La Universidad se registro exitosamente");
            }
        } catch (Exception e) {
            System.out.println("Ups! Hubo un problema al intentar registrar la universidad");
            e.printStackTrace();
            } finally{
                conexion.CloseConexion();
            }
        return insert;
    }

    public static boolean UperCaseByNit(ConexionDB conexion, String nombre, String nit, String direccion, String email){
        boolean upercasenit = false;
        try {
            String query ="UPDATE universidades SET nombre=?, direccion=?, email=? WHERE nit=?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, email);
            pst.setString(4, nit);
            upercasenit = pst.executeUpdate() == 1 ? true : false;
            if(upercasenit){
                System.out.println("La Universidad se actualizó exitosamente");
            }else{
                System.out.println("Universidad no encontrada");
            }
        } catch (Exception e) {
            System.out.println("Ups! Hubo un problema al intentar actualizar la universidad " + nit);
            e.printStackTrace();
        }finally{
            conexion.CloseConexion();
        }
        return upercasenit;
    }

    public static boolean UperCaseByName(ConexionDB conexion, String nombre, String nit, String direccion, String email){
        boolean upercasename = false;
        try {
            String query ="UPDATE universidades SET nit=?, direccion=?, email=? WHERE nombre=?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            pst.setString(2, direccion);
            pst.setString(3, email);
            pst.setString(4, nombre);
            upercasename = pst.executeUpdate() == 1 ? true : false;
            if(upercasename){
                System.out.println("La Universidad se actualizó exitosamente");
            }else{
                System.out.println("Universidad no encontrada");
            }
        } catch (Exception e) {
            System.out.println("Ups! Hubo un problema al intentar actualizar la universidad " + nombre);
            e.printStackTrace();
        }finally{
            conexion.CloseConexion();
        }
        return upercasename;
    }

    public static ResultSet ReadByNit(ConexionDB conexion, String nit){
        ResultSet resultbynit = null;

        return resultbynit;
    }

    public static ResultSet ReadByName(ConexionDB conexion, String nombre){
        ResultSet read = null;

        return read;
    }

    public boolean Delete(){
        boolean delete = false;

        return delete;
    }
    //#endregion Consultas SQL 
}
