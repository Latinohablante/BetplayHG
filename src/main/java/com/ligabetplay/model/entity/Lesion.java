package com.ligabetplay.model.entity;

import java.time.LocalDate;

public class Lesion {
    private Long id;
    private Jugador jugador;
    private String tipo;
    private String gravedad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Getters y setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Jugador getJugador() {
        return jugador;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getGravedad() {
        return gravedad;
    }
    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Getters y setters

    
}
