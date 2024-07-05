package com.ligabetplay.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ligabetplay.controller.ControllerDate;
import com.ligabetplay.controller.Keyunique;
import com.ligabetplay.model.entity.Equipo;
import com.ligabetplay.model.entity.Jugador;

public class viewJugadores {
    public static void gestorJugadores() {
        ControllerDate controlador = new ControllerDate();
        int opcion = 0;
        while (opcion != 6) {
            try {
                String[] options = {"Crear Jugador", "Modificar Jugador", "Buscar Jugador", "Eliminar Jugador", "Mostrar Jugadores", "Salir"};
                opcion = JOptionPane.showOptionDialog(null, "Administración de Jugadores\nSeleccione una opción:", "Menu Jugadores",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (opcion) {
                    case 0:
                        int keyJ = Keyunique.generateUniqueKeyJ(controlador.jugadores);
                        String nombre = JOptionPane.showInputDialog(null, "Nombre del jugador:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del jugador:"));
                        String posicion = JOptionPane.showInputDialog(null, "Posición del jugador:");
                        String nacionalidad = JOptionPane.showInputDialog(null, "Nacionalidad del jugador:");
                        int numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de camiseta del jugador:"));
                        String nombreEquipo = JOptionPane.showInputDialog(null, "Nombre del equipo:");
                        Integer keyEquipo = controlador.findKeyEquipo(nombreEquipo);

                        if (keyEquipo == null) {
                            JOptionPane.showMessageDialog(null, "¡No se encontró un equipo con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        Equipo equipo = controlador.equipos.get(keyEquipo);
                        Jugador jugador = new Jugador(Integer.toString(keyJ), nombre, edad, posicion, nacionalidad, numeroCamiseta, equipo, null, null);
                        controlador.jugadores.put(keyJ, jugador);
                        equipo.addJugador(jugador); // Método para añadir jugador al equipo
                        break;
                    case 1:
                        if (controlador.jugadores.size() > 0) {
                            String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador a modificar:");
                            Integer key = controlador.findKeyJugador(nombreJugador);
                            if (key == null) {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un jugador con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                                continue;
                            }
                            boolean flag = controlador.checkExistenceJugador(key);
                            while (flag) {
                                String namePlayer = controlador.getNombreJugador(key);
                                String[] editOptions = {"Editar nombre", "Editar edad", "Editar posición", "Editar nacionalidad", "Editar número de camiseta", "Salir"};
                                int choice2 = JOptionPane.showOptionDialog(null, "Jugador: " + namePlayer.toUpperCase() + "\nSeleccione una opción:", "Modificar Jugador",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, editOptions, editOptions[0]);
                                switch (choice2) {
                                    case 0:
                                        String newName = JOptionPane.showInputDialog(null, "Nuevo nombre del jugador:");
                                        controlador.setNombreJugador(key, newName);
                                        break;
                                    case 1:
                                        int newAge = Integer.parseInt(JOptionPane.showInputDialog(null, "Nueva edad del jugador:"));
                                        controlador.setEdadJugador(key, newAge);
                                        break;
                                    case 2:
                                        String newPosition = JOptionPane.showInputDialog(null, "Nueva posición del jugador:");
                                        controlador.setPosicionJugador(key, newPosition);
                                        break;
                                    case 3:
                                        String newNationality = JOptionPane.showInputDialog(null, "Nueva nacionalidad del jugador:");
                                        controlador.setNacionalidadJugador(key, newNationality);
                                        break;
                                    case 4:
                                        int newNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Nuevo número de camiseta del jugador:"));
                                        controlador.setNumeroCamisetaJugador(key, newNumber);
                                        break;
                                    case 5:
                                        flag = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "¡Entrada no válida, elija una opción entre 1 y 6!", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay jugadores registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        if (controlador.jugadores.size() > 0) {
                            String nombreJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador a buscar:");
                            Integer key = controlador.findKeyJugador(nombreJugador);
                            if (key != null) {
                                Jugador findPlayer = controlador.jugadores.get(key);
                                String nombreP = findPlayer.getNombre();
                                int edadP = findPlayer.getEdad();
                                String posicionP = findPlayer.getPosicion();
                                String nacionalidadP = findPlayer.getNacionalidad();
                                int numeroCamisetaP = findPlayer.getNumeroCamiseta();
                                Equipo equipoP = findPlayer.getEquipo();
                                JOptionPane.showMessageDialog(null, String.format(
                                        "Nombre: %s\nEdad: %d\nPosición: %s\nNacionalidad: %s\nNúmero de camiseta: %d\nEquipo: %s",
                                        nombreP, edadP, posicionP, nacionalidadP, numeroCamisetaP, equipoP.getNombre()), "Jugador Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un jugador con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay jugadores registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (controlador.jugadores.size() > 0) {
                            String nameJugador = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador a eliminar:");
                            Integer key = controlador.findKeyJugador(nameJugador);
                            if (key != null) {
                                Jugador jugadorAEliminar = controlador.jugadores.get(key);
                                jugadorAEliminar.getEquipo().removeJugador(jugadorAEliminar); // Método para eliminar jugador del equipo
                                controlador.removePlayer(key);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un jugador con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay jugadores registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        if (controlador.jugadores.size() != 0) {
                            showPlayersTable(controlador);
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay jugadores registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void showPlayersTable(ControllerDate controlador) {
        String[] columns = {"ID", "Nombre", "Edad", "Posición", "Nacionalidad", "Número de camiseta", "Equipo"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        controlador.jugadores.values().forEach(jugador -> {
            Object[] row = {jugador.getId(), jugador.getNombre(), jugador.getEdad(), jugador.getPosicion(), jugador.getNacionalidad(), jugador.getNumeroCamiseta(), jugador.getEquipo().getNombre()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Lista de Jugadores", JOptionPane.PLAIN_MESSAGE);
    }
}
