/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Beans.Vendor;
import java.util.ArrayList;

/**
 *
 * @author AlexisDev
 */
public class Item {
    private String name;
    private String code;
    private String description;
    private float cost;
    private ArrayList<Vendor> vendors;
    private int reOrderPoint;
    private int onHand;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public ArrayList<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(ArrayList<Vendor> vendors) {
        this.vendors = vendors;
    }

    public int getReOrderPoint() {
        return reOrderPoint;
    }

    public void setReOrderPoint(int reOrderPoint) {
        this.reOrderPoint = reOrderPoint;
    }

    public int getOnHand() {
        return onHand;
    }

    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }
    
    
    
}
