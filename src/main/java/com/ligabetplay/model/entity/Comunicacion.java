package com.ligabetplay.model.entity;

import java.time.LocalDate;
import java.util.List;

public class Comunicacion {
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
    private List<Usuario> destinatarios;

    // Getters y setters
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public List<Usuario> getDestinatarios() {
        return destinatarios;
    }
    public void setDestinatarios(List<Usuario> destinatarios) {
        this.destinatarios = destinatarios;
    }

    // Getters y setters

    
}
