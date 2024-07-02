package com.ligabetplay.controller;

import com.ligabetplay.model.entity.Role;

public class MenuAccess {
    private Role role;

    public MenuAccess(Role role) {
        this.role = role;
    }

    public void showMenu() {
        role.accessMenu();
    }
}
    

