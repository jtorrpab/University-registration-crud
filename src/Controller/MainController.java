package Controller;

import Model.Dao.ConexionDB;
import View.Menu;

public class MainController {
 
    public MainController(){
        try {
            ConexionDB conexionDB = new ConexionDB();
            UniversidadController uController = new UniversidadController(conexionDB);
            Menu menu = new Menu(uController);
            menu.MenuPrincipal(conexionDB);
            //uController.CreateUniversidad("Pepito", "Prueba7", "Prueba3", "Prueba4");
            //uController.UpdateUniversidadByNit(conexionDB, "Pepito", "Prueba2", "Carrera", "AAA");
            //uController.UpdateUniversidadByName(conexionDB, "Prueba5", "1234", "Calle", "BBB");
            //uController.ReadUniversidadByNit(conexionDB, "Prueba2");
            //uController.ReadUniversidadByName(conexionDB, "Pepito");
            //uController.SelectAll(conexionDB);
            //uController.DeleteUniversidadByNit(conexionDB, "Prueba7");
            //uController.DeleteUniversidadByName(conexionDB, "Pepito");
            //uController.DeleteAllUniversidades(conexionDB);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
