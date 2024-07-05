package com.ligabetplay.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ligabetplay.controller.ControllerDate;
import com.ligabetplay.controller.Keyunique;
import com.ligabetplay.model.entity.Equipo;

public class viewEquipos {
    public static void gestorEquipos(){
        ControllerDate controlador = new ControllerDate();
        int opcion = 0;
        while (opcion != 6) {
            try{
                String[] options = {"Crear Equipo", "Modificar Equipo", "Buscar Equipo", "Eliminar Equipo", "Mostrar Equipos", "Salir"};
                opcion = JOptionPane.showOptionDialog(null, "Administración de Equipos\nSeleccione una opción:", "Menu Equipos",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (opcion) {
                    case 0:
                        int keyT = Keyunique.generateUniqueKeyT(controlador.equipos);
                        String name = JOptionPane.showInputDialog(null, "Nombre del equipo:");
                        String ciudad = JOptionPane.showInputDialog(null, "Ciudad del equipo:");
                        String estadio = JOptionPane.showInputDialog(null, "Estadio del equipo:");
                        String trainer = JOptionPane.showInputDialog(null, "Entrenador del equipo:");
                        Equipo equipo = new Equipo(keyT, name, ciudad, estadio, trainer);
                        controlador.equipos.put(keyT, equipo);
                        break;
                    case 1:
                        if (controlador.equipos.size() > 0 ) { 
                            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo a modificar:");
                            Integer key = controlador.findKeyEquipo(nombre);
                            if (key == null) {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un equipo con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                                continue;
                            }
                            boolean flag = controlador.checkExistenceEquipo(key);
                            while (flag) {
                                String nameTeam = controlador.getNombreEquipo(key);
                                String[] editOptions = {"Editar nombre", "Editar ciudad", "Editar estadio", "Editar entrenador", "Salir"};
                                int choice2 = JOptionPane.showOptionDialog(null, "Equipo: " + nameTeam.toUpperCase() + "\nSeleccione una opción:", "Modificar Equipo",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, editOptions, editOptions[0]);
                                switch (choice2) {
                                    case 0:
                                        String newName = JOptionPane.showInputDialog(null, "Nuevo nombre del equipo:");
                                        controlador.setNombreEquipo(key, newName);
                                        break;
                                    case 1:
                                        String newCity = JOptionPane.showInputDialog(null, "Nueva ciudad del equipo:");
                                        controlador.setCity(key, newCity);
                                        break;
                                    case 2:
                                        String newStadium = JOptionPane.showInputDialog(null, "Nuevo estadio del equipo:");
                                        controlador.setStadium(key, newStadium);
                                        break;
                                    case 3:
                                        String newTrainer = JOptionPane.showInputDialog(null, "Nuevo entrenador del equipo:");
                                        controlador.setTrainer(key, newTrainer);
                                        break;
                                    case 4:
                                        flag = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "¡Entrada no válida, elija una opción entre 1 y 5!", "Error", JOptionPane.ERROR_MESSAGE);
                                        break;
                                }  
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay equipos registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        if (controlador.equipos.size() > 0) {
                            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo a buscar:");
                            Integer key = controlador.findKeyEquipo(nombre);
                            if (key != null) {
                                Equipo findTeam = controlador.equipos.get(key);
                                String nombreP = findTeam.getNombre();
                                String ciudadP = findTeam.getCiudad();
                                String estadioP = findTeam.getEstadio();
                                String entrenadorP = findTeam.getEntrenador();
                                int players = (findTeam.getJugadores() != null) ? findTeam.getJugadores().size() : 0;
                                int partidos = (findTeam.getPartidos() != null) ? findTeam.getPartidos().size() : 0;
                                JOptionPane.showMessageDialog(null, String.format(
                                        "Nombre: %s\nCiudad: %s\nEstadio: %s\nEntrenador: %s\nJugadores: %d\nPartidos: %d",
                                        nombreP, ciudadP, estadioP, entrenadorP, players, partidos), "Equipo Encontrado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un equipo con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay equipos registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        if (controlador.equipos.size() > 0) {
                            String nameEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo a eliminar:");
                            Integer key = controlador.findKeyEquipo(nameEquipo);
                            if (key != null) {
                                controlador.removeTeam(key);
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encontró un equipo con ese nombre!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay equipos registrados!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        if (controlador.equipos.size() != 0) {
                            showTeamsTable(controlador);
                        } else {
                            JOptionPane.showMessageDialog(null, "¡No hay equipos registrados!", "Error", JOptionPane.ERROR_MESSAGE);
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

    private static void showTeamsTable(ControllerDate controlador) {
        String[] columns = {"ID", "Nombre", "Ciudad", "Estadio", "Entrenador"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        controlador.equipos.values().forEach(equipo -> {
            Object[] row = {equipo.getId(), equipo.getNombre(), equipo.getCiudad(), equipo.getEstadio(), equipo.getEntrenador()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Lista de Equipos", JOptionPane.PLAIN_MESSAGE);
    }
}
