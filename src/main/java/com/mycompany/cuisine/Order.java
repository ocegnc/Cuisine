/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author oce_g
 */
public class Order {
    
    private File filename;
    private String id;
    private ArrayList<OrderDTO> startersList;
    private ArrayList<OrderDTO> coursesList;
    private ArrayList<OrderDTO> dessertsList;

    public Order() {
        startersList = new ArrayList<OrderDTO>();
        coursesList = new ArrayList<OrderDTO>();
        dessertsList = new ArrayList<OrderDTO>();
        this.filename = new File("C:/Users/oce_g/NetBeans/Projets/Cuisine/order_10_58_53.json");
        ReadStarters();
        ReadCourses();
        ReadDesserts();
    }

    public String getId() {
        return id;
    }

    public ArrayList<OrderDTO> getStartersList() {
        return startersList;
    }

    public ArrayList<OrderDTO> getCoursesList() {
        return coursesList;
    }

    public ArrayList<OrderDTO> getDessertsList() {
        return dessertsList;
    }
    
    private void ReadStarters() {
        JSONParser parser = new JSONParser();
        try{
        JSONObject jo = (JSONObject) parser.parse(new FileReader(filename));
        
        this.id = (String) jo.get("id");
        System.out.println("Commande n°" + id);
        
        JSONArray starters = (JSONArray) jo.get("starters");
        for (Object obj1 : starters){
            OrderDTO startersDTO = new OrderDTO((JSONObject) obj1);
            startersList.add(startersDTO);
            System.out.println(startersDTO);
        }
        }catch (IOException e) {
                e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void ReadCourses() {
        JSONParser parser = new JSONParser();
        try{
        JSONObject jo = (JSONObject) parser.parse(new FileReader(filename));
        JSONArray mainCourses = (JSONArray) jo.get("main_courses");
        for (Object obj1 : mainCourses){
            OrderDTO coursesDTO = new OrderDTO((JSONObject) obj1);
            coursesList.add(coursesDTO);
            System.out.println(coursesDTO);
        }
        }catch (IOException e) {
                e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void ReadDesserts() {
        JSONParser parser = new JSONParser();
        try{
        JSONObject jo = (JSONObject) parser.parse(new FileReader(filename));
        JSONArray desserts = (JSONArray) jo.get("desserts");
        for (Object obj1 : desserts){
            OrderDTO dessertsDTO = new OrderDTO((JSONObject) obj1);
            dessertsList.add(dessertsDTO);
            System.out.println(dessertsDTO);
        }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
