package Controller;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Dao.ConexionDB;
import Model.Dao.UniversidadDao;


public class UniversidadController {
    
    private ConexionDB conexionDB; 
    private ArrayList<UniversidadDao> universidades;

    public UniversidadController(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
        this.universidades = new ArrayList<UniversidadDao>();
    }

    public boolean CreateUniversidad(String nombre, String nit, String direccion, String email){
        UniversidadDao Registro_Universidad = new UniversidadDao(nombre, nit, direccion, email);
        boolean insert = Registro_Universidad.Insert(conexionDB);
        if(insert){
            this.universidades.add(Registro_Universidad);
            System.out.println("La Universidad se añadió correctamente");
        }
        
        return insert;
    }

    public boolean UpdateUniversidadByNit(ConexionDB conexion, String nombre, String nit, String direccion, String email){
        return UniversidadDao.UperCaseByNit(conexion, nombre, nit, direccion, email);
    }

    public boolean UpdateUniversidadByName(ConexionDB conexion, String nombre, String nit, String direccion, String email){
        return UniversidadDao.UperCaseByName(conexion, nombre, nit, direccion, email);
    }

    public ResultSet ReadUniversidadByNit(ConexionDB conexion, String nit){
        return null;
    }

    public void ReadUniversidadByName(){

    }

    public void DeleteUniversidad(){

    }
}
