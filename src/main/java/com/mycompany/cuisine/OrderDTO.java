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
    private long id;
    private long qty;

    public OrderDTO(JSONObject jo) {
        this.id = (long) jo.get(id);
        this.qty = (long) jo.get(qty);
    }

    public long getId() {
        return id;
    }

    public long getQty() {
        return qty;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", qty: " + getQty();
    }
    
}
