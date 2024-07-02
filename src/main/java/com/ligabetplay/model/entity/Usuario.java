package com.ligabetplay.model.entity;

public class Usuario extends Persona {
    private String email;
    private String password;
    private Role rol;

    public Usuario() {
        super();
    }
    public Usuario(String id, String nombre) {
        super(id, nombre);
    }
    public Usuario(String email, String password, Role rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    public Usuario(String id, String nombre, String email, String password, Role rol) {
        super(id, nombre);
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRol() {
        return rol;
    }
    public void setRol(Role rol) {
        this.rol = rol;
    }
    
}
