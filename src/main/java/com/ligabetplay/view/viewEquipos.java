package com.ligabetplay.view;

import java.text.MessageFormat;
import java.util.Scanner;

import com.ligabetplay.controller.ControllerDate;
import com.ligabetplay.controller.Keyunique;
import com.ligabetplay.model.entity.Equipo;

public class viewEquipos {
    public static void gestorEquipos(){
        ControllerDate controlador = new ControllerDate();
        Scanner scanner = new Scanner(System.in);
        // Menú de opciones
        int opcion = 0;
        while (opcion != 6) {
            try{
                System.out.println("\t");
                System.out.println("  Team Administration");
                System.out.println("___________________________");
                System.out.println("1. Create Team");
                System.out.println("2. Update Team");
                System.out.println("3. Search Team");
                System.out.println("4. Remove Team");
                System.out.println("5. Show Teams");
                System.out.println("6. Exit.");
                System.out.println("===========================");
                System.out.print("-> Choose an option: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                switch (opcion) {
                    case 1:
                        //Generamos llave unica
                        int keyT = Keyunique.generateUniqueKeyT(controlador.equipos);
                        System.out.print("Nombre: ");
                        String name = scanner.nextLine();
                        System.out.print("Ciudad: ");
                        String ciudad = scanner.nextLine();
                        System.out.print("Estadio: ");
                        String estadio = scanner.nextLine();
                        System.out.print("Entrenador: ");
                        String trainer = scanner.nextLine();
                        Equipo equipo = new Equipo(keyT, name, ciudad,estadio, trainer);
                        controlador.equipos.put(keyT, equipo);
                        break;
                    case 2:
                        if (controlador.equipos.size() > 0 ) { 
                            System.out.print("Ingrese el nombre del equipo que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador.findKeyEquipo(nombre);
                            if (key == null) {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a team whit that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                continue;
                            }
                            boolean flag = controlador.checkExistenceEquipo(key);

                            while (flag) {
                                //
                                String nameTeam = controlador.getNombreEquipo(key);
                                System.out.println("\t");
                                System.out.println(MessageFormat.format("       {0}", nameTeam.toUpperCase()));
                                System.out.println("___________________________");
                                System.out.println("1. Editar nombre");
                                System.out.println("2. Editar ciudad");
                                System.out.println("3. Editar estadio");
                                System.out.println("4. Editar entrenador");
                                System.out.println("5. Salir");
                                System.out.println("=============================");
                                System.out.print("Elija una opción: ");
                                int choice2 = scanner.nextInt();
                                scanner.nextLine(); // Consume newline   
                                    switch (choice2) {
                                        case 1:
                                            System.out.println("\t");  
                                            System.out.print("New team name: ");
                                            String newName = scanner.nextLine();
                                            controlador.setNombreEquipo(key, newName);
                                            break;
                                        case 2:
                                            System.out.println("\t"); 
                                            System.out.print("New team city: ");
                                            String newCity = scanner.nextLine();
                                            controlador.setCity(key, newCity);
                                            break;
                                        case 3:
                                            System.out.println("\t"); 
                                            System.out.print("New team stadium: ");
                                            String newStadium = scanner.nextLine();
                                            controlador.setCity(key, newStadium);
                                            break;
                                        case 4:
                                            System.out.println("\t"); 
                                            System.out.print("New trainer: ");
                                            String newTrainer = scanner.nextLine();
                                            controlador.setTrainer(key, newTrainer);
                                            break;
                                        case 5:
                                            flag = false;
                                            break;
                                    
                                        default:
                                            System.out.println("\t");
                                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                            System.out.println("¡Invalid input, enter a number between 1 and 5!");
                                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                            break;
                                    }  
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not teams yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                        }
                        break;

                    case 3:
                        if (controlador.equipos.size() > 0) {

                            System.out.print("Ingrese el nombre del equipo que quiere modificar: ");
                            String nombre = scanner.nextLine();
                            Integer key = controlador.findKeyEquipo(nombre);
                            System.out.println("ENCONTRE LA KEY: " + key);
                            if (key != null) {
                                Equipo findTeam = controlador.equipos.get(key);
                                String nombreP = findTeam.getNombre();
                                String ciudadP = findTeam.getCiudad();
                                String estadioP = findTeam.getEstadio();
                                String entrenadorP = findTeam.getEntrenador();
                                int players = 0;
                                int partidos = 0;
                                if (findTeam.getJugadores() != null) {
                                    players = findTeam.getJugadores().size();   
                                } else {
                                    players = 0;
                                }
                                if (findTeam.getPartidos() != null) {
                                    findTeam.getPartidos().size();  
                                } else {
                                    partidos = 0;
                                }
                                System.out.println("\n");
                                System.out.println("______________________________________________");
                                System.out.println("\tName:   \t" + nombreP);
                                System.out.println("\tCity:   \t" + ciudadP);
                                System.out.println("\tEstadio: \t" + estadioP);
                                System.out.println("\tTrainer: \t" + entrenadorP);
                                System.out.println("\tPlayers: \t" + players);
                                System.out.println("\tPartidos: \t" + partidos);
                                System.out.println("==============================================");

                            } else {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡There isn't a team whit that name!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not teams yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            continue;    
                        }
                        break;
                    case 4:
                        if (controlador.equipos.size() > 0) {
                            System.out.print("Ingrese el nombre del equipo que quiere eliminar: ");
                            String nameEquipo = scanner.nextLine();
                            Integer key = controlador.findKeyEquipo(nameEquipo);

                            if (key != null) {
                                controlador.removeTeam(key);
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Not teams yet!");
                            System.out.println("@@@@@@@@@@@@@@@@@@"); 
                        }
                        break;
                    case 5:
                        if (controlador.equipos.size() != 0) {
                            controlador.showTeams();
                        }
                        break;
                    case 6:
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
                System.out.println("Formato invalido. Input a nùmber!" + e);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                scanner.nextLine();
            } 
        } 
        
    }

}  

