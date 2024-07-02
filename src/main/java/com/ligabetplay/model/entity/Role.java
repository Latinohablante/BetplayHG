package com.ligabetplay.model.entity;

import java.util.List;

public interface Role {
    void accessMenu();

    //metodos para --> Role Admin <--
    int getId();
    void setId(int id);
    String getRol(); 
    void setRol(String rol);
    List<Permiso> getLstPermits();
    void setLstPermits(List<Permiso> lstPermits);

    //metodos para --> Role  Equipo Tecnico<--
    

}


    