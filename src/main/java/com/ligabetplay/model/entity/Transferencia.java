package com.ligabetplay.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia {
    private Long id;
    private Jugador jugador;
    private Equipo equipoOrigen;
    private Equipo equipoDestino;
    private BigDecimal monto;
    private LocalDate fecha;

    // Getters and setters
    
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
    public Equipo getEquipoOrigen() {
        return equipoOrigen;
    }
    public void setEquipoOrigen(Equipo equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }
    public Equipo getEquipoDestino() {
        return equipoDestino;
    }
    public void setEquipoDestino(Equipo equipoDestino) {
        this.equipoDestino = equipoDestino;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getters y setters
}
