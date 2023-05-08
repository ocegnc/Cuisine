/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author oce_g
 */
public class Counter extends JSpinner {
    
    private final Font font;
    
    public Counter(Font font){
        this.font = font;
        setUp();
    }
    
    private void setUp(){
        SpinnerModel model = new SpinnerNumberModel(0, 0, 500, 1);
        setModel(model);
        setFont(font);
    }

    void reset() {
        this.setValue(0);
    }

    public int get(){
        return (Integer)this.getValue();
    }
    
}
