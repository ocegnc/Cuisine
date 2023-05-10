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
public class OrderDTO {
    private int id;
    private int qty;

    public OrderDTO(JSONObject jo) {
        this.id = Integer.parseInt(jo.get("id").toString());
        this.qty = Integer.parseInt(jo.get("qty").toString());
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "id: " + getId() + ", qty: " + getQty();
    }
    
}
