/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import org.json.simple.JSONObject;

/**
 *
 * @author oce_g
 */
public class MealDTO {
    private int id;
    private String name;
    private int qty;

    public MealDTO(int id, String name, int qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("description", name);
        obj.put("qty", qty);
        return obj;
    }

}
