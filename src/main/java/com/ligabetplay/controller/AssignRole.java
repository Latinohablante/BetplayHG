package com.ligabetplay.controller;

import java.util.ArrayList;
import java.util.Hashtable;

import com.ligabetplay.model.entity.Permiso;


public class AssignRole {
    public static Hashtable<String,ArrayList<Permiso>> permits = new Hashtable<>();
    public static void createRoles() {
        ArrayList<Permiso> lstAdminPermits = new ArrayList<>();
        ArrayList<Permiso> lstStPermits = new ArrayList<>();
        ArrayList<Permiso> lstRefereePermits = new ArrayList<>();
        ArrayList<Permiso> lstPassionatePermits = new ArrayList<>();
        ArrayList<Permiso> lstJournalistPermits = new ArrayList<>();
        ArrayList<Permiso> lstDoctorPermits = new ArrayList<>();
        //Creamos gestiones del proyecto
        Permiso permiso1 = new Permiso(1, "Gestión de Equipos");
        Permiso permiso2 = new Permiso(2, "Gestión de Jugadores");
        Permiso permiso3 = new Permiso(3, "Programación de Partidos");
        Permiso permiso4 = new Permiso(4, "Registro de Resultados");
        Permiso permiso5 = new Permiso(5, "Gestión de Noticias y Comunicados");
        Permiso permiso6 = new Permiso(6, "Gestión de Entrenadores");
        Permiso permiso7 = new Permiso(7, "Gestión de Arbitros");
        Permiso permiso8 = new Permiso(8, "Gestión de Estadios");
        Permiso permiso9 = new Permiso(9, "Gestión de Patrocinios");
        Permiso permiso10 = new Permiso(10, "Generación de Informes");
        Permiso permiso11 = new Permiso(11, "Gestión de Incidentes y Sanciones");
        Permiso permiso12 = new Permiso(12, "Gestión de Medios de Comunicaciòn");
        Permiso permiso13 = new Permiso(13, "Gestión de Transferencias de Jugadores");
        Permiso permiso14 = new Permiso(14, "Gestión de Equipamiento");
        Permiso permiso15 = new Permiso(15, "Gestión de Premios y Reconocimientos");
        Permiso permiso16 = new Permiso(16, "Gestión de Usuarios y Roles");
        Permiso permiso17 = new Permiso(17, "Visualización de Estadisticas");
        Permiso permiso18 = new Permiso(18, "Consulta de Calendario de Partidos");
        Permiso permiso19 = new Permiso(19, "Gestión de Lesiones del Jugador");
        Permiso permiso20 = new Permiso(20, "Gestión de Entrenamientos");
        Permiso permiso21 = new Permiso(21, "Seguimiento de Rendimiento de Jugadores");
        Permiso permiso22 = new Permiso(22, "Gestión de Convocatorias de Jugadores");
        Permiso permiso23 = new Permiso(23, "Venta de Entradas");
        //Agregamos permisos de admin  
        lstAdminPermits.add(permiso1);
        lstAdminPermits.add(permiso2); 
        lstAdminPermits.add(permiso3); 
        lstAdminPermits.add(permiso4); 
        lstAdminPermits.add(permiso5); 
        lstAdminPermits.add(permiso6); 
        lstAdminPermits.add(permiso7); 
        lstAdminPermits.add(permiso8); 
        lstAdminPermits.add(permiso9); 
        lstAdminPermits.add(permiso10);
        lstAdminPermits.add(permiso11);
        lstAdminPermits.add(permiso12); 
        lstAdminPermits.add(permiso13); 
        lstAdminPermits.add(permiso14); 
        lstAdminPermits.add(permiso15); 
        lstAdminPermits.add(permiso16);
        //Agregamos permisos de cuerpo tecnico
        lstStPermits.add(permiso2);
        lstStPermits.add(permiso17);
        lstStPermits.add(permiso6);
        lstStPermits.add(permiso10);
        lstStPermits.add(permiso18);
        lstStPermits.add(permiso19);
        lstStPermits.add(permiso20);
        lstStPermits.add(permiso21);
        lstStPermits.add(permiso13);
        lstStPermits.add(permiso14);
        lstStPermits.add(permiso22);
        //Agregamos permisos de entrenador
        lstRefereePermits.add(permiso4);
        lstRefereePermits.add(permiso11);
        //Agregamos permisos de aficionados
        lstPassionatePermits.add(permiso17);
        lstPassionatePermits.add(permiso23);
        lstPassionatePermits.add(permiso18);
        //Agregamos permisos de periodistas
        lstJournalistPermits.add(permiso17);
        lstJournalistPermits.add(permiso5);
        lstJournalistPermits.add(permiso18);
        lstJournalistPermits.add(permiso12);
        //Agregamos permisos de doctores
        lstDoctorPermits.add(permiso19);
        //Añadimos las listas de permisos a un HashTable
        permits.put("Administrador de la Liga", lstAdminPermits);
        permits.put("Equipo Técnico", lstStPermits);
        permits.put("Arbitro", lstRefereePermits);
        permits.put("Aficionado", lstPassionatePermits);
        permits.put("Periodista", lstJournalistPermits);
        permits.put("Médico del Equipo", lstDoctorPermits);
    }

}
