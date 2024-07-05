package com.ligabetplay.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.ligabetplay.model.entity.Permiso;

public class viewAdmin {

    public static void showMenu(List<Permiso> permisos) {
        int opcion = 0;
        while (opcion != permisos.size() + 1) {
            try {
                StringBuilder menu = new StringBuilder("\n             Menú Administration\n");
                menu.append("____________________________________________\n");
                for (int i = 0; i < permisos.size(); i++) {
                    Permiso item = permisos.get(i);
                    menu.append(String.format("%d. %s\n", i + 1, item.getDescripcion()));
                }
                menu.append(String.format("%d. Salir\n", permisos.size() + 1));
                menu.append("=============================================\n");
                menu.append("Seleccione una opción:");

                String input = JOptionPane.showInputDialog(null, menu.toString(), "Menú Administración", JOptionPane.PLAIN_MESSAGE);
                if (input == null) break; // Si el usuario cierra el cuadro de diálogo
                opcion = Integer.parseInt(input);

                if (opcion > 0 && opcion <= permisos.size() + 1) {
                    switch (opcion) {
                        case 1:
                            viewEquipos.gestorEquipos();
                            break;
                        case 2:
                            viewJugadores.gestorJugadores();
                            break;
                        case 3:
                            // buscarTarea(archivo, tareaBuscar);
                            break;
                        case 4:
                            // eliminarTarea(archivo, tareaEliminar);
                            break;
                        case 17:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
