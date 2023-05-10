/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.simple.parser.ParseException;

/**
 *
 * @author oce_g
 */
public class MyKitchen extends JFrame{
    
    private Font font;
    private int fontSize;
    private String title;
    private int cpt;
    private Menu menu;
    
    public MyKitchen() throws ParseException{
        this("Ocean'sKitchen", 15);
    }
    
    public MyKitchen(String title, int fontSize) throws ParseException {
        super(title);
        cpt = 1;
        menu = new Menu();
        this.title = title;
        this.fontSize = fontSize;
        this.setUpAndDisplay();
    }
    
    private void setUpAndDisplay() {
        font = new FontUIResource("Arial", Font.PLAIN, fontSize);
        setLayout(new FlowLayout());
        
        JPanel user = new JPanel();      
        
        //Créer une liste déroulante
        String[] meal = {"Starters", "Main courses", "Desserts"};
        JComboBox cb = new JComboBox(meal);
        user.add(cb);
        
        //Créer une entrée pour l'utilisateur
        TextPanel text1 = new TextPanel("NAME :", font);
        user.add(text1);
        
        //Créer un compteur
        CountPanel quantity = new CountPanel("QUANTITY :", font);
        user.add(quantity);
        
        
        //Création tables dans les onglets
        //Créer des onglets
        JPanel starters = new JPanel();
        JPanel mainCourses = new JPanel();
        JPanel desserts = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(100,100,300,100);
        tabs.add("Starters", starters);
        tabs.add("Main Courses", mainCourses);
        tabs.add("Desserts", desserts);
        
        // Table des entrées    
        Table tabStart = new Table("Starters of the day", font);
        JScrollPane scroll = new JScrollPane(tabStart);
        scroll.setPreferredSize(new Dimension(800, 500));
        starters.add(scroll);
        
        // Table des plats
        Table tabMeal = new Table("Main courses of the day", font);
        JScrollPane scroll2 = new JScrollPane(tabMeal);
        scroll2.setPreferredSize(new Dimension(800, 500));
        mainCourses.add(scroll2);
        
        // Table des plats
        Table tabDessert = new Table("Desserts of the day", font);
        JScrollPane scroll3 = new JScrollPane(tabDessert);
        scroll3.setPreferredSize(new Dimension(800, 500));
        desserts.add(scroll3);
        
        //Créer un bouton
        Button addButton = new Button("ADD", font);
        Button clearButton = new Button("CLEAR", font);
        Button commitButton = new Button("COMMIT", font);
        Button upgradeButton = new Button("UPGRADE", font);
        user.add(addButton).setBackground(Color.GREEN);
        user.add(clearButton).setBackground(Color.LIGHT_GRAY);
        
        //Listener addButton
        addButton.addActionListener((e) -> {
            Vector v = new Vector();
            v.add(text1.getText());
            v.add(quantity.get());
            v.add(cpt);
           
            if (cb.getSelectedItem().equals("Starters")){
                DefaultTableModel dt1 = (DefaultTableModel) tabStart.getModel();
                dt1.addRow(v);
                MealDTO s = new MealDTO(cpt++, text1.getText(), quantity.get());
                menu.getStartersList().add(s);
            }
            if (cb.getSelectedItem().equals("Main courses")){
                DefaultTableModel dt2 = (DefaultTableModel) tabMeal.getModel();
                dt2.addRow(v);
                MealDTO c = new MealDTO(cpt++, text1.getText(), quantity.get());
                menu.getCoursesList().add(c);
            }
            if (cb.getSelectedItem().equals("Desserts")){
                DefaultTableModel dt3 = (DefaultTableModel) tabDessert.getModel();
                dt3.addRow(v);
                MealDTO d = new MealDTO(cpt++, text1.getText(), quantity.get());
                menu.getDessertsList().add(d);
            }
        });
      
        //Listener clearButton
        clearButton.addActionListener((e) -> {
            text1.reset();
            quantity.reset();
        });
        
        //Listener commitButton
        commitButton.addActionListener((e) -> {
            menu.WriteMenu();
        });
        
        //Listener upgradeButton
        upgradeButton.addActionListener((e) -> {
            Order order = new Order();
            
            System.out.println("Inventaire des plats : ");
            ArrayList<OrderDTO> startersList = order.getStartersList();
            for(OrderDTO startersDTO : startersList){
                int qty = startersDTO.getQty();
                long id = startersDTO.getId();
                for(MealDTO s : menu.getStartersList()){
                    if (id==s.getId() && qty<s.getQty()){
                        s.setQty((int) (s.getQty()-qty));
                        System.out.println(s.getNom() + " --> Quantité restante : " + s.getQty());
                    } else if (id==s.getId() && qty>=s.getQty()) {
                        System.out.println(s.getNom() + " : RUPTURE DE STOCK");
                    } 
                }
            }
            ArrayList<OrderDTO> coursesList = order.getCoursesList();
            for(OrderDTO coursesDTO : coursesList){
                int qty = coursesDTO.getQty();
                int id = coursesDTO.getId();
                for(MealDTO c : menu.getCoursesList()){
                    if (id==c.getId() && qty<c.getQty()){
                        c.setQty((int) (c.getQty()-qty));
                        System.out.println(c.getNom() + " --> Quantité restante: " + c.getQty());
                    } else if (id==c.getId() && qty>=c.getQty()) {
                        System.out.println(c.getNom() + " : RUPTURE DE STOCK");
                    }
                }
            }
            ArrayList<OrderDTO> dessertsList = order.getDessertsList();
            for(OrderDTO dessertsDTO : dessertsList){
                int qty = dessertsDTO.getQty();
                int id = dessertsDTO.getId();
                for(MealDTO d : menu.getDessertsList()){
                    if (id==d.getId() && qty<d.getQty()){
                        d.setQty((int) (d.getQty()-qty));
                        System.out.println(d.getNom() + " --> Quantité restante : " + d.getQty());
                    }if (id==d.getId() && qty>=d.getQty()) {
                        System.out.println(d.getNom() + " : RUPTURE DE STOCK");
                    }
                }
            }
        });
        
        add(user);
        add(commitButton);
        add(upgradeButton).setBackground(Color.YELLOW);
        add(tabs);
        
        pack();
        //Redimensionnement optimal
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Positionnement au centre de l'écran
        setLocationRelativeTo(null);
        // Affichage
        setVisible(true);
    } 
}
