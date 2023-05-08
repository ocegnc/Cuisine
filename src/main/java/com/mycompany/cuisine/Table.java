/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author oce_g
 */
public class Table extends JTable{
    
    private String name;
    private Font font;
    
    public Table(String name, Font font){
        this.name = name;
        this.font = font;
        setUp();
    }
    
    private void setUp(){
        String[] columns = new String[]{
            name, "Quantity", "n°ID"
        };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        this.setModel(model);
        setFillsViewportHeight(true);
        TableColumnModel columnModel = this.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(500);
        columnModel.getColumn(1).setPreferredWidth(20);
        columnModel.getColumn(2).setPreferredWidth(20);
    }

    void addRow(Vector v) {
        this.addRow(v);
    }

  
}
