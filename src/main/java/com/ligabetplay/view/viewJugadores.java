package com.ligabetplay.view;

import java.text.MessageFormat;
import java.util.Scanner;

import com.ligabetplay.controller.ControllerDate;
import com.ligabetplay.controller.Keyunique;
import com.ligabetplay.model.entity.Equipo;
import com.ligabetplay.model.entity.Jugador;

public class viewJugadores {
    public static void gestorJugadores() {
        ControllerDate controlador = new ControllerDate();
        Scanner scanner = new Scanner(System.in);
        // Menú de opciones
        int opcion = 0;
        while (opcion != 6) {
            try {
                System.out.println("\t");
                System.out.println("  Player Administration");
                System.out.println("___________________________");
                System.out.println("1. Create Player");
                System.out.println("2. Update Player");
                System.out.println("3. Search Player");
                System.out.println("4. Remove Player");
                System.out.println("5. Show Players");
                System.out.println("6. Exit.");
                System.out.println("===========================");
                System.out.print("-> Choose an option: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        // Generamos llave unica
                        int keyJ = Keyunique.generateUniqueKeyJ(controlador.jugadores);
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Posición: ");
                        String posicion = scanner.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = scanner.nextLine();
                        System.out.print("Número de Camiseta: ");
                        int numeroCamiseta = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Equipo: ");
                        String nombreEquipo = scanner.nextLine();
                        Integer keyEquipo = controlador.findKeyEquipo(nombreEquipo);
                        
                        if (keyEquipo == null) {
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡No se encontró un equipo con ese nombre!");
                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            break;
                        }

                        Equipo equipo = controlador.equipos.get(keyEquipo);
                        Jugador jugador = new Jugador(Integer.toString(keyJ), nombre, edad, posicion, nacionalidad, numeroCamiseta, equipo, null, null);
                        controlador.jugadores.put(keyJ, jugador);
                        equipo.addJugador(jugador); // Método para añadir jugador al equipo
                        break;
                    case 2:
                        if (controlador.jugadores.size() > 0) {
                            System.out.print("Ingrese el nombre del jugador que quiere modificar: ");
                            String nombreJugador = scanner.nextLine();
                            Integer key = controlador.findKeyJugador(nombreJugador);
                            if (key == null) {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡No se encontró un jugador con ese nombre!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                continue;
                            }
                            boolean flag = controlador.checkExistenceJugador(key);

                            while (flag) {
                                String namePlayer = controlador.getNombreJugador(key);
                                System.out.println("\t");
                                System.out.println(MessageFormat.format("       {0}", namePlayer.toUpperCase()));
                                System.out.println("___________________________");
                                System.out.println("1. Editar nombre");
                                System.out.println("2. Editar edad");
                                System.out.println("3. Editar posición");
                                System.out.println("4. Editar nacionalidad");
                                System.out.println("5. Editar número de camiseta");
                                System.out.println("6. Salir");
                                System.out.println("=============================");
                                System.out.print("Elija una opción: ");
                                int choice2 = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                switch (choice2) {
                                    case 1:
                                        System.out.println("\t");
                                        System.out.print("New player name: ");
                                        String newName = scanner.nextLine();
                                        controlador.setNombreJugador(key, newName);
                                        break;
                                    case 2:
                                        System.out.println("\t");
                                        System.out.print("New age: ");
                                        int newAge = scanner.nextInt();
                                        scanner.nextLine();
                                        controlador.setEdadJugador(key, newAge);
                                        break;
                                    case 3:
                                        System.out.println("\t");
                                        System.out.print("New position: ");
                                        String newPosition = scanner.nextLine();
                                        controlador.setPosicionJugador(key, newPosition);
                                        break;
                                    case 4:
                                        System.out.println("\t");
                                        System.out.print("New nationality: ");
                                        String newNationality = scanner.nextLine();
                                        controlador.setNacionalidadJugador(key, newNationality);
                                        break;
                                    case 5:
                                        System.out.println("\t");
                                        System.out.print("New shirt number: ");
                                        int newNumber = scanner.nextInt();
                                        scanner.nextLine();
                                        controlador.setNumeroCamisetaJugador(key, newNumber);
                                        break;
                                    case 6:
                                        flag = false;
                                        break;
                                    default:
                                        System.out.println("\t");
                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                        System.out.println("¡Entrada no válida, elija un número entre 1 y 6!");
                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Aún no hay jugadores!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                        }
                        break;
                    case 3:
                        if (controlador.jugadores.size() > 0) {
                            System.out.print("Ingrese el nombre del jugador que quiere buscar: ");
                            String nombreJugador = scanner.nextLine();
                            Integer key = controlador.findKeyJugador(nombreJugador);
                            if (key != null) {
                                Jugador findPlayer = controlador.jugadores.get(key);
                                String nombreP = findPlayer.getNombre();
                                int edadP = findPlayer.getEdad();
                                String posicionP = findPlayer.getPosicion();
                                String nacionalidadP = findPlayer.getNacionalidad();
                                int numeroCamisetaP = findPlayer.getNumeroCamiseta();
                                Equipo equipoP = findPlayer.getEquipo();
                                System.out.println("\n");
                                System.out.println("______________________________________________");
                                System.out.println("\tName:          \t" + nombreP);
                                System.out.println("\tAge:           \t" + edadP);
                                System.out.println("\tPosition:      \t" + posicionP);
                                System.out.println("\tNationality:   \t" + nacionalidadP);
                                System.out.println("\tShirt Number:  \t" + numeroCamisetaP);
                                System.out.println("\tTeam:          \t" + equipoP.getNombre());
                                System.out.println("==============================================");

                            } else {
                                System.out.println("\t");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡No se encontró un jugador con ese nombre!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Aún no hay jugadores!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            continue;
                        }
                        break;
                    case 4:
                        if (controlador.jugadores.size() > 0) {
                            System.out.print("Ingrese el nombre del jugador que quiere eliminar: ");
                            String nameJugador = scanner.nextLine();
                            Integer key = controlador.findKeyJugador(nameJugador);

                            if (key != null) {
                                Jugador jugadorAEliminar = controlador.jugadores.get(key);
                                jugadorAEliminar.getEquipo().removeJugador(jugadorAEliminar); // Método para eliminar jugador del equipo
                                controlador.removePlayer(key);
                            } else {
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("¡No se encontró un jugador con ese nombre!");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                            }
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Aún no hay jugadores!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                        }
                        break;
                    case 5:
                        if (controlador.jugadores.size() != 0) {
                            controlador.showPlayers();
                        } else {
                            System.out.println("\t");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
                            System.out.println("¡Aún no hay jugadores!");
                            System.out.println("@@@@@@@@@@@@@@@@@@");
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
