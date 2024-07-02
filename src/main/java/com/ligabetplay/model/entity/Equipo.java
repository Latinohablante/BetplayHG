package com.ligabetplay.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private Integer id;
    private String nombre;
    private String ciudad;
    private String estadio;
    private String entrenador;
    private List<Jugador> jugadores;
    private List<Partido> partidos;
    
    // Getters y setters
    
    public Equipo(Integer id, String nombre, String ciudad, String estadio, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.entrenador = entrenador;
    }
    public Equipo() {
        jugadores = new ArrayList<Jugador>();
        partidos = new ArrayList<Partido>();

    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    public String getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public List<Partido> getPartidos() {
        return partidos;
    }
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    
}
