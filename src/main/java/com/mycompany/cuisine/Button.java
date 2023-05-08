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
public class Button extends JButton{
    
    private final Font font;
    
    public Button(String text, Font font){
        super(text);
        this.font = font;
        setUp();
    }
    
    private void setUp(){
        setFont(font);
        setBackground(Color.ORANGE);
    }
    
    
}
