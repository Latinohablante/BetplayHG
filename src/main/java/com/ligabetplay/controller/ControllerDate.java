package com.ligabetplay.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import com.ligabetplay.model.entity.Equipo;
import com.ligabetplay.model.entity.Jugador;

public class ControllerDate {
    public Hashtable <Integer,Equipo> equipos = new Hashtable<>();
    public Hashtable <Integer, Jugador> players = new Hashtable<>();
    //bUSCAR EXISTENCIA DE KEY
    public boolean checkExistence(Integer key){
        Equipo foundTeam = equipos.get(key);
        if(foundTeam == null) {
            return false;
        } else {
            return true;
        }
    }
    //ENCONTRAR LLAVE
    public Integer findKeyEquipo(String nameEquipo){
        for (Integer key : equipos.keySet()) {
            if (equipos.get(key).getNombre().equals(nameEquipo)) {
                return key;
            }
        }
        return null;
    }
    public String getNombre(Integer key){
        String p =  equipos.get(key).getNombre();
        if(p == null) {
            return "Error al intentar leer el nombre de la clase.";
        } else {
            return p;
        }
    }
    public void setNombre(Integer key, String newName) {
        Equipo modifiedTeam = equipos.get(key);
            modifiedTeam.setNombre(newName);
    }

    public void setCity(Integer key, String newCity){
        Equipo modifiedTeam = equipos.get(key);
        if (modifiedTeam != null) {
            modifiedTeam.setCiudad(newCity);
        }  
    }
    public void setStadium(Integer key, String newStadium){
        Equipo modifiedTeam = equipos.get(key);
        if (modifiedTeam != null) {
            modifiedTeam.setEstadio(newStadium);;
        }  
    }
    public void setTrainer(Integer key, String newTrainer){
        Equipo modifiedTeam = equipos.get(key);
        if (modifiedTeam != null) {
            modifiedTeam.setEstadio(newTrainer);;
        }  
    }
    public void removeTeam(Integer key){
        Equipo teamRemove = new Equipo();
        String nombre = equipos.get(key).getNombre();
        teamRemove = equipos.remove(key);
        if (teamRemove != null) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(MessageFormat.format("Team {0} has been remove succesfully.", nombre.toUpperCase() ));
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); 
        }
    }
    public void showTeams(){  
        ArrayList<String> playersList = new ArrayList<>();
        int players = 0;
        int partidos = 0;
        for (Equipo valor : equipos.values()) {

            if (valor.getJugadores() != null) {
                players = valor.getJugadores().size();   
            } else {
                players = 0;
            }
            if (valor.getPartidos() != null) {
                valor.getPartidos().size();  
            } else {
                partidos = 0;
            }
            System.out.println("\n");
            System.out.println("______________________________________________");
            System.out.println("\tName:   \t" + valor.getNombre());
            System.out.println("\tCity:   \t" + valor.getCiudad());
            System.out.println("\tEstadio: \t" + valor.getEstadio());
            System.out.println("\tTrainer: \t" + valor.getEntrenador());
            System.out.println("\tPlayers: \t" + players);
            System.out.println("\tPartidos: \t" + partidos);
            System.out.println("==============================================");

            playersList.clear();
        }
    }

}        

