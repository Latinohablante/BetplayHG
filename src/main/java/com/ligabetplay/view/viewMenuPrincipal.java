package com.ligabetplay.view;

import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 2) {
            try {
                System.out.println("_______________________________");
                System.out.println("         Liga BetPlay");
                System.out.println("_______________________________");
                System.out.println("1. Acceder.");
                System.out.println("2. Exit.");
                System.out.println("===============================");
                    System.out.print("-> Choose an option: ");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("\n");
                        System.out.println("===========================");
                        System.out.println("          Access");
                        System.out.println("___________________________");
                        System.out.print("User    : ");
                        String email = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        System.out.println("===========================");
                        if (email.equals("admin")) {
                            ArrayList<Permiso> lstPermits = AssignRole.permits.get("Administrador de la Liga");
                            Role adminrRole = new AdminRole(00, "Administrador de la Liga", lstPermits);
                            Usuario admin = new Usuario("admin", "admin123", adminrRole);
                            if (admin.getPassword().equals(password)) {
                                MenuAccess accederAdmin = new MenuAccess(adminrRole);
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
                        }else if (email.equals("doctor")) {
                            ArrayList<Permiso> lstPermits = AssignRole.permits.get("Médico del Equipo");
                            Role doctorRole = new com.ligabetplay.model.roles.doctorRole(05, "Médico del Equipo", lstPermits);
                            Usuario doctor = new Usuario("doctor", "doctor123", doctorRole);
                            if (doctor.getPassword().equals(password)) {
                                MenuAccess accederDoctor = new MenuAccess(doctorRole);
                                accederDoctor.showMenu();
                            }
                        }
                        break;
                    case 2:
                        scanner.close();
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


