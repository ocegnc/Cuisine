/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author oce_g
 */
public class CountPanel extends JPanel {
    
    private Font font;
    private String count;
    private Counter counter;
    
    public CountPanel(String count, Font font){
        this.count = count;
        this.font = font;
        setUp();
    }
    
    private void setUp(){
        setFont(font);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        add(new JLabel(count));
        counter = new Counter(font);
        add(counter);
    }

    void reset() {
        counter.reset();
    }

    public int get(){
        return counter.get();
    }
    
}
