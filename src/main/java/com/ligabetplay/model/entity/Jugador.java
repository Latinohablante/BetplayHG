package com.ligabetplay.model.entity;

import java.util.List;

public class Jugador extends Persona{
    private int edad;
    private String posicion;
    private String nacionalidad;
    private int numeroCamiseta;
    private Equipo equipo;
    private List<Lesion> lesiones;
    private List<Rendimiento> rendimientos;
    
    //CONTRUCTORS
    public Jugador(String id, String nombre, int edad, String posicion, String nacionalidad, int numeroCamiseta,Equipo equipo, List<Lesion> lesiones, List<Rendimiento> rendimientos) {
        super(id, nombre);
        this.edad = edad;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;
        this.lesiones = lesiones;
        this.rendimientos = rendimientos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Lesion> getLesiones() {
        return lesiones;
    }

    public void setLesiones(List<Lesion> lesiones) {
        this.lesiones = lesiones;
    }

    public List<Rendimiento> getRendimientos() {
        return rendimientos;
    }

    public void setRendimientos(List<Rendimiento> rendimientos) {
        this.rendimientos = rendimientos;
    }

}