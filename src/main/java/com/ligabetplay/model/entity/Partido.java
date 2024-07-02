package com.ligabetplay.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Partido {
    private Long id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private LocalDate fecha;
    private LocalTime hora;
    private String estadio;
    private List<Gol> goles;
    private List<Tarjeta> tarjetas;
    private List<Incidente> incidentes;
    private Resultado resultado;

    // Getters y setters

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
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
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    public List<Gol> getGoles() {
        return goles;
    }
    public void setGoles(List<Gol> goles) {
        this.goles = goles;
    }
    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }
    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
    public List<Incidente> getIncidentes() {
        return incidentes;
    }
    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
    public Resultado getResultado() {
        return resultado;
    }
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    // Getters y setters

    
}
