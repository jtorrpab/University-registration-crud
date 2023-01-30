package View;

import java.util.Scanner;
import Controller.UniversidadController;
import Model.Dao.ConexionDB;

public class Menu {
    
    private UniversidadController uController;

    public Menu(UniversidadController uController){
        this.uController = uController;
    }

    public void MenuPrincipal(ConexionDB conexion){

        UniversidadView uView = new UniversidadView(uController, conexion);
        String mensaje =  "\n---------------BIENVENIDOS--------------------\n";
        mensaje += "1) Crear universidad\n";
        mensaje += "2) Mostrar todas las univerisdades\n";
        mensaje += "3) Consultar universidad\n";
        mensaje += "4) Actualizar universidad\n";
        mensaje += "5) Eliminar universidad\n";
        mensaje += "-1) Salir\n";
        mensaje += ">>> ";

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (opcion != -1){
            System.out.print(mensaje);
            opcion = sc.nextInt();
            switch(opcion){
                case 1: 
                uView.CrearUniversidad(sc);
                break;
                case 2:
                uView.MostrarUniversidad();
                break;
                case 3:
                uView.ConsultarUniversidad();
                break;
                case 4:
                uView.ActualizarUniversidad();
                break;
                case 5:
                uView.EliminarUniversidad();
                break;
                }
            }
            conexion.CloseConexion();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar el menu");
        }
    }
}
