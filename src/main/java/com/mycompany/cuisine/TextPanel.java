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
public class TextPanel extends JPanel{
    
    private Font font;
    private String text;
    private JTextField textMeal;
    
    public TextPanel(String text, Font font){
        this.text = text;
        this.font = font;
        setUp();
    }
    
    private void setUp(){
        setFont(font);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        textMeal = new JTextField(30);
        add(new JLabel(text));
        add(textMeal);
    }

    void reset() {
        textMeal.setText("");
    }
    
    public String getText() {
        return textMeal.getText();
    }
    
}
