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

        } catch (Exception e) {
            System.out.println("Ups! Hubo un problema al intentar registrar la universidad");
            e.printStackTrace();
            } finally{
                conexion.CloseConexion();
            }
        return insert;
    }

    public boolean UperCase(){
        boolean upercase = false;

        return upercase;
    }

    public static ResultSet Read(ConexionDB conexion){
        ResultSet read = null;

        return read;
    }

    public boolean Delete(){
        boolean delete = false;

        return delete;
    }
    //#endregion Consultas SQL 
}
