package com.ligabetplay.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ligabetplay.model.entity.Actividad;

public class Entrenamiento {
    private Long id;
    private Equipo equipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private List<Actividad> actividades;
    private List<Jugador> jugadoresConvocados;

    // Getters y setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public List<Actividad> getActividades() {
        return actividades;
    }
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    public List<Jugador> getJugadoresConvocados() {
        return jugadoresConvocados;
    }
    public void setJugadoresConvocados(List<Jugador> jugadoresConvocados) {
        this.jugadoresConvocados = jugadoresConvocados;
    }

    // Getters y setters

    
}
