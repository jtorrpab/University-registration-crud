package Controller;

import Model.Dao.ConexionDB;

public class MainController {
 
    public MainController(){
        try {
            ConexionDB conexionDB = new ConexionDB();
            UniversidadController uController = new UniversidadController(conexionDB);
            //uController.CreateUniversidad("Prueba1", "Prueba2", "Prueba3", "Prueba4");
            //uController.UpdateUniversidadByNit(conexionDB, "Pepito", "Prueba2", "Carrera", "AAA");
            //uController.UpdateUniversidadByName(conexionDB, "Prueba5", "1234", "Calle", "BBB");
            //uController.ReadUniversidadByNit(conexionDB, "Prueba2");
            //uController.SelectAll(conexionDB);
            //uController.DeleteUniversidadByNit(conexionDB, "1234");
            uController.DeleteUniversidadByName(conexionDB, "Pepito");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
