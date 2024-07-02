package com.ligabetplay.view;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import com.ligabetplay.model.entity.Permiso;

public class viewDoctor {

    public static void  showMenu(List<Permiso> permisos){
        Scanner scanner = new Scanner(System.in);
        // Menú de opciones
        int opcion = 0;
        while (opcion != 2) {
            try{
                int contador = 1;
                String indez = "";
                /*----------Encabezado--------------- */
                //System.out.println("____________________________________________");
                System.out.println("\n             Menú Doctor");
                System.out.println("____________________________________________");
                for (Permiso item : permisos) {
                    indez += contador + ".";
                    System.out.printf("| %5s |%s.%n", indez, item.getDescripcion());
                    //System.out.printf("%-5s %-25s %s%n", contador, item.getDescripcion());
                    contador++;
                    indez = "";
                }
                /*-----------Footer------------------ */
                System.out.println(MessageFormat.format("|    {0}. |Exit.", contador));
                System.out.println("=============================================");
                System.out.print("-> Choose an option: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                contador = 1;
    
                switch (opcion) {
                    case 1:
                        System.out.print("Escribe la tarea a agregar: ");
                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("@@@@@@@@@@@@@@@@@");
                        System.out.println("Opción no válida.");
                        System.out.println("@@@@@@@@@@@@@@@@@");
                        break;
                }
            } catch (Exception e) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Formato invalido. Input a nùmber!");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.nextLine();
            } 
        } 
        
    }
}
