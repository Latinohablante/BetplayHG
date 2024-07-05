package com.ligabetplay.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ligabetplay.controller.AssignRole;
import com.ligabetplay.controller.MenuAccess;
import com.ligabetplay.model.entity.Permiso;
import com.ligabetplay.model.entity.Role;
import com.ligabetplay.model.entity.Usuario;
import com.ligabetplay.model.roles.AdminRole;
import com.ligabetplay.model.roles.AmateurRole;
import com.ligabetplay.model.roles.JournalistRole;
import com.ligabetplay.model.roles.RefereeRol;
import com.ligabetplay.model.roles.StRole;

public class viewMenuPrincipal {
    public static void showMenu() {
        int option = 0;
        while (option != 2) {
            try {
                String[] options = {"Acceder", "Salir"};
                option = JOptionPane.showOptionDialog(null, "Liga BetPlay\nSeleccione una opción:", "Menu Principal",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (option == 0) {
                    String email = JOptionPane.showInputDialog(null, "Ingrese su usuario:");
                    String password = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");

                    if (email.equals("admin")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Administrador de la Liga");
                        Role adminRole = new AdminRole(00, "Administrador de la Liga", lstPermits);
                        Usuario admin = new Usuario("admin", "admin123", adminRole);
                        if (admin.getPassword().equals(password)) {
                            MenuAccess accederAdmin = new MenuAccess(adminRole);
                            accederAdmin.showMenu();
                        }
                    } else if (email.equals("stecnico")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Equipo Técnico");
                        Role stRole = new StRole(01, "Equipo Técnico", lstPermits);
                        Usuario stecnico = new Usuario("stecnico", "stecnico123", stRole);
                        if (stecnico.getPassword().equals(password)) {
                            MenuAccess accederSt = new MenuAccess(stRole);
                            accederSt.showMenu();
                        }
                    } else if (email.equals("referee")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Arbitro");
                        Role refereeRole = new RefereeRol(02, "Arbitro", lstPermits);
                        Usuario referee = new Usuario("referee", "referee123", refereeRole);
                        if (referee.getPassword().equals(password)) {
                            MenuAccess accederReferee = new MenuAccess(refereeRole);
                            accederReferee.showMenu();
                        }
                    } else if (email.equals("amateur")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Aficionado");
                        Role amateurRole = new AmateurRole(03, "Aficionado", lstPermits);
                        Usuario amateur = new Usuario("amateur", "amateur123", amateurRole);
                        if (amateur.getPassword().equals(password)) {
                            MenuAccess accederAmateur = new MenuAccess(amateurRole);
                            accederAmateur.showMenu();
                        }
                    } else if (email.equals("journalist")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Periodista");
                        Role periodistaRole = new JournalistRole(04, "Periodista", lstPermits);
                        Usuario journalist = new Usuario("journalist", "journalist123", periodistaRole);
                        if (journalist.getPassword().equals(password)) {
                            MenuAccess accederPeriodista = new MenuAccess(periodistaRole);
                            accederPeriodista.showMenu();
                        }
                    } else if (email.equals("doctor")) {
                        ArrayList<Permiso> lstPermits = AssignRole.permits.get("Médico del Equipo");
                        Role doctorRole = new com.ligabetplay.model.roles.doctorRole(05, "Médico del Equipo", lstPermits);
                        Usuario doctor = new Usuario("doctor", "doctor123", doctorRole);
                        if (doctor.getPassword().equals(password)) {
                            MenuAccess accederDoctor = new MenuAccess(doctorRole);
                            accederDoctor.showMenu();
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato inválido. Por favor ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
