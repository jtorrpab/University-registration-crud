package Controller;
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
            System.out.println("La Universidad se registro exitosamente");
        }
        
        return insert;
    }

    public void UpdateUniversidad(){

    }

    public void ReadUniversidad(){

    }

    public void DeleteUniversidad(){

    }
}
