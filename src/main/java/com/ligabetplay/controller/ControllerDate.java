package com.ligabetplay.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import com.ligabetplay.model.entity.Equipo;
import com.ligabetplay.model.entity.Jugador;

public class ControllerDate {
    public Hashtable<Integer, Equipo> equipos = new Hashtable<>();
    public Hashtable<Integer, Jugador> jugadores = new Hashtable<>();

    // Buscar existencia de key para equipos
    public boolean checkExistenceEquipo(Integer key) {
        return equipos.get(key) != null;
    }

    // Buscar existencia de key para jugadores
    public boolean checkExistenceJugador(Integer key) {
        return jugadores.get(key) != null;
    }

    // Encontrar llave de equipo
    public Integer findKeyEquipo(String nameEquipo) {
        for (Integer key : equipos.keySet()) {
            if (equipos.get(key).getNombre().equals(nameEquipo)) {
                return key;
            }
        }
        return null;
    }

    // Encontrar llave de jugador
    public Integer findKeyJugador(String nombreJugador) {
        for (Integer key : jugadores.keySet()) {
            if (jugadores.get(key).getNombre().equals(nombreJugador)) {
                return key;
            }
        }
        return null;
    }

    // Métodos para equipos
    public String getNombreEquipo(Integer key) {
        return equipos.get(key).getNombre();
    }

    public void setNombreEquipo(Integer key, String newName) {
        equipos.get(key).setNombre(newName);
    }

    public void setCity(Integer key, String newCity) {
        equipos.get(key).setCiudad(newCity);
    }

    public void setStadium(Integer key, String newStadium) {
        equipos.get(key).setEstadio(newStadium);
    }

    public void setTrainer(Integer key, String newTrainer) {
        equipos.get(key).setEntrenador(newTrainer);
    }

    public void removeTeam(Integer key) {
        Equipo teamRemove = equipos.remove(key);
        if (teamRemove != null) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(MessageFormat.format("Team {0} has been removed successfully.", teamRemove.getNombre().toUpperCase()));
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }

    public void showTeams() {
        for (Equipo valor : equipos.values()) {
            int players = valor.getJugadores() != null ? valor.getJugadores().size() : 0;
            int partidos = valor.getPartidos() != null ? valor.getPartidos().size() : 0;

            System.out.println("\n");
            System.out.println("______________________________________________");
            System.out.println("\tName:   \t" + valor.getNombre());
            System.out.println("\tCity:   \t" + valor.getCiudad());
            System.out.println("\tStadium:\t" + valor.getEstadio());
            System.out.println("\tTrainer:\t" + valor.getEntrenador());
            System.out.println("\tPlayers:\t" + players);
            System.out.println("\tMatches:\t" + partidos);
            System.out.println("==============================================");
        }
    }

    // Métodos para jugadores
    public String getNombreJugador(Integer key) {
        return jugadores.get(key).getNombre();
    }

    public void setNombreJugador(Integer key, String newName) {
        jugadores.get(key).setNombre(newName);
    }

    public void setEdadJugador(Integer key, int newAge) {
        jugadores.get(key).setEdad(newAge);
    }

    public void setPosicionJugador(Integer key, String newPosition) {
        jugadores.get(key).setPosicion(newPosition);
    }

    public void setNacionalidadJugador(Integer key, String newNationality) {
        jugadores.get(key).setNacionalidad(newNationality);
    }

    public void setNumeroCamisetaJugador(Integer key, int newNumber) {
        jugadores.get(key).setNumeroCamiseta(newNumber);
    }

    public void removePlayer(Integer key) {
        Jugador playerRemove = jugadores.remove(key);
        if (playerRemove != null) {
            playerRemove.getEquipo().removeJugador(playerRemove);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(MessageFormat.format("Player {0} has been removed successfully.", playerRemove.getNombre().toUpperCase()));
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }

    public void showPlayers() {
        for (Jugador valor : jugadores.values()) {
            System.out.println("\n");
            System.out.println("______________________________________________");
            System.out.println("\tName:          \t" + valor.getNombre());
            System.out.println("\tAge:           \t" + valor.getEdad());
            System.out.println("\tPosition:      \t" + valor.getPosicion());
            System.out.println("\tNationality:   \t" + valor.getNacionalidad());
            System.out.println("\tShirt Number:  \t" + valor.getNumeroCamiseta());
            System.out.println("\tTeam:          \t" + valor.getEquipo().getNombre());
            System.out.println("==============================================");
        }
    }
}
