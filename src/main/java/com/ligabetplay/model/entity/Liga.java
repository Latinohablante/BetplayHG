package com.ligabetplay.model.entity;

import java.util.List;

public class Liga {
    private Long id;
    private String nombre;
    private List<Equipo> equipos;
    private List<Patrocinador> patrocinadores;

    //Getters and setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    public List<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }
    public void setPatrocinadores(List<Patrocinador> patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    // Getters y setters

    
}
