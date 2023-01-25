package View;

import java.sql.ResultSet;
import java.util.Scanner;
// import javax.swing.JOptionPane;
// import org.w3c.dom.traversal.NodeIterator;
import Controller.UniversidadController;
import Model.Dao.ConexionDB;

public class UniversidadView {
    
    private UniversidadController uController;
    private ConexionDB conexion;

    public UniversidadView(UniversidadController uController, ConexionDB conexion){
        this.uController = uController;
        this.conexion = conexion;
    }

//#region Create
    public void CrearUniversidad(Scanner sc){
        System.out.println("\n--------------- REGISTRAR UNIVERSIDAD-------------------------");
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
        // String encabezado = "-------------CREAR UNIVERSIDAD-----------\n";
        // encabezado += "Por favor ingrese la siguiente informacion\n";
        // // --SOLICITAR DATOS
        // String nit = JOptionPane.showInputDialog(null, encabezado + "Nit: ");
        // String nombre = JOptionPane.showInputDialog(null, encabezado + "Nombre: ");
        // String direccion = JOptionPane.showInputDialog(null, encabezado + "Dirección: ");
        // String email = JOptionPane.showInputDialog(null, encabezado + "Email: ");
        // // Crear universidad
        // boolean insert = uController.CreateUniversidad(nit, nombre, direccion, email);
        // if (insert) {
        //     JOptionPane.showMessageDialog(null, "\n\nUniversidad creada con exito");
        // } else {
        //     JOptionPane.showMessageDialog(null, "\n\nPor favor intenta mas tarde");
        // }
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

    public void ConsultarUniversidad(){
        System.out.println("\n---------------CONSULTAR UNIVERSIDAD---------------------");
        String mensaje = "\nComo desea consultar la Universidad\n";
        mensaje += "1) Consultar por Nit\n";
        mensaje += "2) Consultar por Nombre\n";
        mensaje += "-1) <-\n";
        mensaje += ">>> ";

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch(opcion){
                    case 1: 
                    ConsultarUniversidadByNit(sc);
                    break;
                    case 2:
                    ConsultarUniversidadByName(sc);
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConsultarUniversidadByNit(Scanner sc){
        System.out.println("\n--------------- CONSULTA POR NIT ---------------------");
        System.out.print("Nit: ");
        String nit = sc.next();
        sc.nextLine();
        System.out.println(" ----------------------------------------------------- ");
        ResultSet universidad = uController.ReadUniversidadByNit(conexion, nit);
        try {
            System.out.println("\n---------------UNIVERSIDADES-------------------------");
            while( universidad.next()){
                String nit_obtenido = universidad.getString(1);
                String nombre_obtenido = universidad.getString(2);
                String direccion_obtenido = universidad.getString(3);
                String email_obtenido = universidad.getString(4);
                System.out.println(" Nit: " + nit_obtenido + "\n Nombre: " + nombre_obtenido + "\n Direccion: " + direccion_obtenido + "\n Email: " + email_obtenido);
                System.out.println(" ----------------------------------------------------- ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ups! No se pudo consultar la Universidad " + nit);
        }
    }

    public void ConsultarUniversidadByName(Scanner sc){
        System.out.println("\n--------------- CONSULTA POR NOMBRE ---------------------");
        System.out.print("Nombre: ");
        String nombre = sc.next();
        sc.nextLine();
        System.out.println(" ----------------------------------------------------- ");
        ResultSet universidad = uController.ReadUniversidadByName(conexion, nombre.toUpperCase());
        try {
            System.out.println("\n---------------UNIVERSIDADES-------------------------");
            while( universidad.next()){
                String nit_obtenido = universidad.getString(1);
                String nombre_obtenido = universidad.getString(2);
                String direccion_obtenido = universidad.getString(3);
                String email_obtenido = universidad.getString(4);
                System.out.println(" Nit: " + nit_obtenido + "\n Nombre: " + nombre_obtenido + "\n Direccion: " + direccion_obtenido + "\n Email: " + email_obtenido);
                System.out.println(" ----------------------------------------------------- ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ups! No se pudo consultar la Universidad " + nombre);
        }
    }
//#endregion
}
