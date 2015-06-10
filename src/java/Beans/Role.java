/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author AlexisDev
 */
public class Role {
    private int id;
    private String name;
    private ArrayList<Permission> permisssions;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Permission> getPermisssions() {
        return permisssions;
    }

    public void setPermisssions(ArrayList<Permission> permisssions) {
        this.permisssions = permisssions;
    }
    
    
    
}
