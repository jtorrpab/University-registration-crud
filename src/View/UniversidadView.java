package View;

import java.sql.ResultSet;
import java.util.Scanner;

import Controller.UniversidadController;

public class UniversidadView {
    
    private UniversidadController uController;

    public UniversidadView(UniversidadController uController){
        this.uController = uController;
    }

//#region Create
    public void CrearUniversidad(Scanner sc){
        System.out.println("-------------- Registrar Universidad --------------");
        System.out.println("\nPor favor ingrese la siguiente informacion");
        System.out.print("Nit: ");
        String nit = sc.next();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        sc.nextLine();
        System.out.print("Direccion: ");
        String direccion = sc.next();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        sc.nextLine();

        boolean insert = uController.CreateUniversidad(nombre, nit, direccion, email);
        if(insert){
            System.out.println("\nUniversidad registrada con exito");
        }else{
            System.out.println("\nUps! No se pudo registrar la universidad");
        }
    }
    //#endregion

//#region Read
    public void MostrarUniversidad(){
        ResultSet universidades = uController.SelectAll();
        try {
            System.out.println("\n---------------UNIVERSIDADES-------------------------");
            while(universidades.next()){
                String nit = universidades.getString(1);
                String nombre = universidades.getString(2);
                String direccion = universidades.getString(3);
                String email = universidades.getString(4);
                System.out.println(" Nit: " + nit + "\n Nombre: " + nombre + "\n Direccion: " + direccion + "\n Email: " + email);
                System.out.println(" ----------------------------------------------------- ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConsultarUniversidad(Scanner sc){
        
    }
//#endregion
}
