package com.ligabetplay.model.roles;

import java.util.ArrayList;
import java.util.List;

import com.ligabetplay.model.entity.Permiso;
import com.ligabetplay.model.entity.Role;
import com.ligabetplay.view.viewDoctor;

public class doctorRole implements Role {
    private int id;
    private String rol;
    private List<Permiso> lstPermits;
    
    
    @Override
    public void accessMenu() {
        viewDoctor.showMenu(lstPermits);
    }
    public doctorRole(int id, String rol, List<Permiso> lstPermits) {
        this.id = id;
        this.rol = rol;
        this.lstPermits = lstPermits;
    }
    public doctorRole() {
        lstPermits = new ArrayList<Permiso>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public List<Permiso> getLstPermits() {
        return lstPermits;
    }
    public void setLstPermits(List<Permiso> lstPermits) {
        this.lstPermits = lstPermits;
    }
}
