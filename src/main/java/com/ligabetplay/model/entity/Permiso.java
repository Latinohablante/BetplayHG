package com.ligabetplay.model.entity;


public class Permiso {
    private Integer id;
    private String descripcion;

    //CONTRUCTORS
    public Permiso(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    // Getters y setters
    public  Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
    
}
