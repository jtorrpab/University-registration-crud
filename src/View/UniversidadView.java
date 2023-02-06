package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
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
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Direccion: ");
        String direccion = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        uController.CreateUniversidad(nombre.toUpperCase(), nit, direccion, email);
        String mensaje = "\nDesea crear otra universidad";
        mensaje += "\n 1) Crear universidad nueva";
        mensaje += "\n-1) Salir";
        mensaje += "\n>>> ";
        int opcion = 0;
        Menu menu = new Menu(uController);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    CrearUniversidad(sc);
                    break;
                    case -1:
                    menu.MenuPrincipal(conexion);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//#endregion

//#region Read
    public void MostrarUniversidad(){
        ResultSet universidades = uController.SelectAll();
        try {
            if(universidades != null){
                System.out.println("\n---------------UNIVERSIDADES-------------------------");
                while(universidades.next()){
                    String nit = universidades.getString(1);
                    String nombre = universidades.getString(2);
                    String direccion = universidades.getString(3);
                    String email = universidades.getString(4);
                    System.out.println(" Nit: " + nit + "\n Nombre: " + nombre + "\n Direccion: " + direccion + "\n Email: " + email);
                    System.out.println(" ----------------------------------------------------- ");
                }
            }else{
                System.out.println("No hay universidades para mostrar");
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
        System.out.println(" ----------------------------------------------------- ");
        ResultSet universidad = uController.ReadUniversidadByNit(conexion, nit);
        try {
            if(universidad != null){
                System.out.println("\n---------------UNIVERSIDADES-------------------------");
                while( universidad.next()){
                    String nit_obtenido = universidad.getString(1);
                    String nombre_obtenido = universidad.getString(2);
                    String direccion_obtenido = universidad.getString(3);
                    String email_obtenido = universidad.getString(4);
                    System.out.println(" Nit: " + nit_obtenido + "\n Nombre: " + nombre_obtenido + "\n Direccion: " + direccion_obtenido + "\n Email: " + email_obtenido);
                    System.out.println(" ----------------------------------------------------- ");
                }
            }else{
                ConsultarUniversidad();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String mensaje = "\n Desea consultar otra universidad";
        mensaje += "\n 1) Consultar";
        mensaje += "\n-1) Salir";
        mensaje += "\n>>> ";
        int opcion = 0;
        Menu menu = new Menu(uController);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    ConsultarUniversidad();
                    break;
                    case -1:
                    menu.MenuPrincipal(conexion);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ConsultarUniversidadByName(Scanner sc){
        System.out.println("\n--------------- CONSULTA POR NOMBRE ---------------------");
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.println(" ----------------------------------------------------- ");
        ResultSet universidad = uController.ReadUniversidadByName(conexion, nombre.toUpperCase());
        try {
            if(universidad != null){
                System.out.println("\n---------------UNIVERSIDADES-------------------------");
                while( universidad.next()){
                    String nit_obtenido = universidad.getString(1);
                    String nombre_obtenido = universidad.getString(2);
                    String direccion_obtenido = universidad.getString(3);
                    String email_obtenido = universidad.getString(4);
                    System.out.println(" Nit: " + nit_obtenido + "\n Nombre: " + nombre_obtenido + "\n Direccion: " + direccion_obtenido + "\n Email: " + email_obtenido);
                    System.out.println(" ----------------------------------------------------- ");
                }
            }else{
                ConsultarUniversidad();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ups! No se pudo consultar la Universidad " + nombre);
        }
        String mensaje = "\n Desea consultar otra universidad";
        mensaje += "\n 1) Consultar";
        mensaje += "\n-1) Salir";
        mensaje += "\n>>> ";
        int opcion = 0;
        Menu menu = new Menu(uController);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    ConsultarUniversidad();
                    break;
                    case -1:
                    menu.MenuPrincipal(conexion);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//#endregion

//#region Update4
    public void ActualizarUniversidad(){
        String mensaje = "\n--------------- ACTUALIZAR UNIVERSIDAD-------------------------";
        mensaje += "\n1) Actualizar universidad por Nit";
        mensaje += "\n2) Actualizar universidad por Nombre";
        mensaje += "\n-1) <-";
        mensaje += "\n>>> ";

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    ActualizarXNit(sc, conexion);
                    break;
                    case 2:
                    ActualizarXNombre(sc, conexion);
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Catch! No se pudo acceder a la actualización");
        }
    }

    public void ActualizarXNit(Scanner sc, ConexionDB conexionDB){
        System.out.println("\n--------------- ACTUALIZAR UNIVERSIDAD POR NIT ---------------------");
        System.out.println("\nPor favor ingrese el nit de la universidad que desea actualizar.");
        System.out.print("Nit: ");
        String nit = sc.next();
        ResultSet uni = uController.ReadUniversidadByNit(conexionDB, nit);
        try {
            if(uni != null){
                System.out.println("\n--------------- Universidad seleccionada ---------------------");
                while(uni.next()){
                    String nit_uni = uni.getString(1);
                    String nombre_uni = uni.getString(2);
                    String dir_uni = uni.getString(3);
                    String email_uni = uni.getString(4);
                    System.out.println(" Nit: " + nit_uni + "\n Nombre: " + nombre_uni + "\n Direccion: " + dir_uni + "\n Email: " + email_uni);
                    System.out.println(" ----------------------------------------------------- ");
                }
            }else{
                ActualizarUniversidad();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Catch! No se puede mostrar la universidad seleccionada");
        }
        sc.nextLine();
        System.out.println("\nPor favor ingrese los siguientes datos para actualizar la universidad " + nit);
        System.out.print("Nombre: ");
        String nombre = sc.next();
        sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.next();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        sc.nextLine();
        boolean universidad = uController.UpdateUniversidadByNit(conexionDB, nombre.toUpperCase(), nit, direccion, email);
        if(universidad){
            System.out.println("\nUniversidad " + nit + " actualizada exitosamente");
            System.out.println("\n------------------ Universidad actualizada ------------- ");
            System.out.println(" Nit: " + nit + "\n Nombre: " + nombre + "\n Direccion: " + direccion + "\n Email: " + email);
            System.out.println(" ----------------------------------------------------- ");
        }
        else{
            System.out.println("Ups! No se pudo actualizar la univesidad");
        }
        String mensaje = "\n Desea actulizar otra universidad";
        mensaje += "\n 1) Consultar";
        mensaje += "\n-1) Salir";
        mensaje += "\n>>> ";
        int opcion = 0;
        Menu menu = new Menu(uController);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    ActualizarUniversidad();
                    break;
                    case -1:
                    menu.MenuPrincipal(conexion);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    public void ActualizarXNombre(Scanner sc, ConexionDB conexionDB){
        System.out.println("\n--------------- ACTUALIZAR UNIVERSIDAD POR NIT ---------------------");
        System.out.println("\nPor favor ingrese el nombre de la universidad que desea actualizar.");
        System.out.print("Nombre: ");
        String nombre = sc.next();
        sc.nextLine();
        ResultSet uni = uController.ReadUniversidadByName(conexionDB, nombre);
        try {
            if(uni != null){
                System.out.println("\n--------------- Universidad seleccionada ---------------------");
                while(uni.next()){
                    String nit_uni = uni.getString(1);
                    String nombre_uni = uni.getString(2);
                    String dir_uni = uni.getString(3);
                    String email_uni = uni.getString(4);
                    System.out.println(" Nit: " + nit_uni + "\n Nombre: " + nombre_uni + "\n Direccion: " + dir_uni + "\n Email: " + email_uni);
                    System.out.println(" ----------------------------------------------------- ");
                }
            }else{
                ActualizarUniversidad();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Catch! No se puede mostrar la universidad seleccionada");
        }
        System.out.println("\nPor favor ingrese los siguientes datos para actualizar la universidad " + nombre);
        System.out.print("Nit: ");
        String nit = sc.next();
        sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.next();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        sc.nextLine();
        boolean result = uController.UpdateUniversidadByName(conexionDB, nombre, nit, direccion, email);
        if(result){
            System.out.println("\nUniversidad " + nombre + " actualizada exitosamente");
            System.out.println("\n------------------ Universidad actualizada ------------- ");
            System.out.println(" Nit: " + nit + "\n Nombre: " + nombre + "\n Direccion: " + direccion + "\n Email: " + email);
            System.out.println(" ----------------------------------------------------- ");
        }else{
            System.out.println("Ups! No se pudo actualizar la univesidad");
        }
        String mensaje = "\n Desea actulizar otra universidad";
        mensaje += "\n 1) Consultar";
        mensaje += "\n-1) Salir";
        mensaje += "\n>>> ";
        int opcion = 0;
        Menu menu = new Menu(uController);
        try {
            while(opcion != -1){
                System.out.print(mensaje);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    ActualizarUniversidad();
                    break;
                    case -1:
                    menu.MenuPrincipal(conexion);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
//#endregion

//#region Delete
public void EliminarUniversidad(){
    String mensaje = "\n ----------------- ELIMINAR UNIVERSIADAD -----------------";
    mensaje += "\n 1) Eliminar todas las universidades";
    mensaje += "\n 2) Eliminar universidad por Nit";
    mensaje += "\n 3) Eliminar universidad por Nombre";
    mensaje += "\n-1) <-";
    mensaje += "\n  >>> ";

    int opcion = 0;
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu(uController);
    try {
        while(opcion != -1){
            System.out.print(mensaje);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                uController.DeleteAllUniversidades(conexion);
                menu.MenuPrincipal(conexion);
                break;
                case 2:
                EliminarXNit(sc, conexion);
                break;
                case 3:
                EliminarXNombre(sc, conexion);
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Catch! No se pudo acceder al modulo deseado");
    }
}

public void EliminarXNit(Scanner sc, ConexionDB conexionDB){
    System.out.println("\n--------------- Eliminar universidad por Nit ------------- ");
    System.out.println("\nPor favor ingrese el nit de la universidad que desea eliminar");
    System.out.print("Nit: ");
    String nit = sc.next();
    sc.nextLine();
    ResultSet universidad = uController.ReadUniversidadByNit(conexion, nit);
    try {
        if(universidad != null){
            System.out.println("\n--------------- Universidad seleccionada ------------- ");
            while( universidad.next()){
                String nit_obtenido = universidad.getString(1);
                String nombre_obtenido = universidad.getString(2);
                String direccion_obtenido = universidad.getString(3);
                String email_obtenido = universidad.getString(4);
                System.out.println(" Nit: " + nit_obtenido + "\n Nombre: " + nombre_obtenido + "\n Direccion: " + direccion_obtenido + "\n Email: " + email_obtenido);
                System.out.println(" ----------------------------------------------------- ");
            }
        }else{
            EliminarUniversidad();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    String mensaje = "\nSeguro desea eliminar la universidad " + nit;
    mensaje += "\n 1) Eliminar";
    mensaje += "\n-1) Cancelar";
    mensaje += "\n  >>> ";

    String mensaje2 = "\nDesea eliminar otra universidad";
    mensaje2 += "\n 1) Eliminar";
    mensaje2 += "\n-1) Salir";
    mensaje2 += "\n  >>> ";

    int opcion = 0;
    Menu menu = new Menu(uController);
    try {    
        while(opcion != -1){
            System.out.print(mensaje);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                uController.DeleteUniversidadByNit(conexionDB, nit);
                System.out.print(mensaje2);
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                    EliminarUniversidad();;
                    break;
                    case -1:
                    menu.MenuPrincipal(conexionDB);
                    break;
                }
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void EliminarXNombre(Scanner sc, ConexionDB conexionDB){
    System.out.println("\n--------------- Eliminar universidad por Nombre ------------- ");
    System.out.println("\nPor favor ingrese el nombre de la universidad que desea eliminar");
    System.out.print("Nombre: ");
    String nombre = sc.next();
    ResultSet universidad = uController.ReadUniversidadByName(conexionDB, nombre.toUpperCase());
    try {
        if(universidad != null){
            while (universidad.next()){
                String nit_read = universidad.getString("nit");
                String nombre_read = universidad.getString("nombre");
                String direccion_read = universidad.getString("direccion");
                String email_read = universidad.getString("email");
                System.out.println("\n--------------- Universidad seleccionada -------------- ");
                System.out.println("Nit: "+ nit_read + "\nNombre: " + nombre_read + "\nDirección: " + direccion_read + "\nEmail: " + email_read);
                System.out.println("--------------------------------------------------- ");
            }
        }else{
            EliminarUniversidad();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    String mensaje = "\n--------------------------------------------------- ";
    mensaje += "\nSeguro desea eliminar la universidad " + nombre;
    mensaje += "\n 1) Eliminar";
    mensaje += "\n-1) Cancelar ";
    mensaje += "\n>>> ";  
    String mensaje2 = "\n--------------------------------------------------- ";
    mensaje2 += "\nDesea eliminar otra universidad?";
    mensaje2 += "\n 1) Eliminar";
    mensaje2 += "\n-1) Cancelar ";
    mensaje2 += "\n>>> "; 
    int opcion = 0;
    Menu menu = new Menu(uController);
    try {
        while(opcion != -1){
            System.out.print(mensaje);
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                uController.DeleteUniversidadByName(conexionDB, nombre.toUpperCase());
                System.out.print(mensaje2);
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                    EliminarUniversidad();
                    break;
                    case -1:
                    menu.MenuPrincipal(conexionDB);
                    break;
                }
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//#endregion

}
