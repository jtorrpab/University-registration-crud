package Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Universidad;

public class UniversidadDao extends Universidad {

    public UniversidadDao(String nombre, String nit, String direccion, String email) {
        super(nombre, nit, direccion, email);
    }
    //ACCIONES  
    //#region Create
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
                System.out.println("\nUniversidad registrada con exito");
            }else{
                System.out.println("\nUps! No se pudo registrar la universidad");
            }
        } catch (Exception e) {
            System.out.println("Catch! Hubo un problema al intentar registrar la universidad");
            e.printStackTrace();
            } 
        return insert;
    }
    //#endregion

    //#region Read
    public static ResultSet SelectAll(ConexionDB conexion){
        ResultSet result = null;
            try {
                String query = "SELECT * FROM universidades";
                result = conexion.getConexion().createStatement().executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se pudo seleccionar ninguna universidad");
            }
        return result;
    }

    public static ResultSet ReadByNit(ConexionDB conexion, String nit){
        ResultSet resultbynit = null;
        try {
            String query ="SELECT * FROM universidades WHERE nit = ?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            resultbynit = pst.executeQuery();
            if(resultbynit != null){
                System.out.println("\nUniversidad encontrada");
            }else{
                System.out.println("\nUniversidad NO encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nCatch! Hubo un problema al seleccionar la universidad " + nit);            
        }
        return resultbynit;
    }

    public static ResultSet ReadByName(ConexionDB conexion, String nombre){
        ResultSet readbyname = null;
        try {
            String query = "SELECT * FROM universidades WHERE nombre = ?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            readbyname = pst.executeQuery();
            if(readbyname != null){
                System.out.println("\nUniversidad encontrada");
            }else{
                System.out.println("\nUniversidad NO encontrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ups! Hubo un problema al seleccionar la universidad " + nombre);
        }
        return readbyname;
    }
    //#endregion

    //#region Update
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
        } catch (Exception e) {
            System.out.println("Cath! Hubo un problema al intentar actualizar la universidad " + nit);
            e.printStackTrace();
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
        } catch (Exception e) {
            System.out.println("Ups! Hubo un problema al intentar actualizar la universidad " + nombre);
            e.printStackTrace();
        }
        return upercasename;
    }
    //#endregion

    //#region Delete
    public static boolean DeleteByNit(ConexionDB conexion, String nit){
        boolean deletebynit = false;
        try {
            String query = "DELETE FROM universidades WHERE nit= ?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            deletebynit = pst.executeUpdate() == 1 ? true : false;
            if(deletebynit){
                System.out.println("\nLa universidad " + nit + " se elimino exitosamente");
            }else{
                System.out.println("\nUps! No se pudo eleiminar la universidad " + nit);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nUps! Hubo un problema al eleiminar la universidad " + nit);
        }
        return deletebynit;
    }

    public static boolean DeleteByName(ConexionDB conexion, String nombre){
        boolean deletebyname = false;
        try {
            String query = "DELETE FROM universidades WHERE nombre= ?";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            deletebyname = pst.executeUpdate() == 1 ? true : false;
            if(deletebyname){
                System.out.println("\nLa universidad " + nombre + " se elimino exitosamente");
            }else{
                System.out.println("\nUps! No se pudo eleiminar la universidad " + nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nUps! Hubo un problema al eleiminar la universidad " + nombre);
        }
        return deletebyname;
    }

    public static boolean DeleteAll(ConexionDB conexion){   
        boolean deleteall = false;
        try {
            String query = "DELETE FROM universidades";
            PreparedStatement pst = conexion.getConexion().prepareStatement(query);
            deleteall = pst.executeUpdate() != 1 ? true : false;
            if(deleteall){
                System.out.println("\nSe han eliminado todos los registros");
            }else{
                System.out.println("\nNo se han eliminado los registors");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nUps! No se pudieron eliminar los registros");
        }
        return deleteall;
    }
    //#endregion
}
