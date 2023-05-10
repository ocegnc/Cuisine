/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuisine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author oce_g
 */
public class Menu {
    
    private ArrayList<MealDTO> startersListM;
    private ArrayList<MealDTO> coursesListM;
    private ArrayList<MealDTO> dessertsListM;

    public Menu() {
        startersListM = new ArrayList<MealDTO>();
        coursesListM = new ArrayList<MealDTO>();
        dessertsListM = new ArrayList<MealDTO>();
    }

    public ArrayList<MealDTO> getStartersList() {
        return startersListM;
    }

    public ArrayList<MealDTO> getCoursesList() {
        return coursesListM;
    }

    public ArrayList<MealDTO> getDessertsList() {
        return dessertsListM;
    }

    public void WriteMenu(){
        JSONObject obj = new JSONObject();
        
        JSONArray starters = new JSONArray();
        for (MealDTO meal : startersListM){
            starters.add(meal.toJson());
        }
        JSONArray mainCourses = new JSONArray();
        for (MealDTO meal : coursesListM){
            mainCourses.add(meal.toJson());
        }
        JSONArray desserts = new JSONArray();
        for (MealDTO meal : dessertsListM){
            desserts.add(meal.toJson());
        }        
        
        obj.put("starters", starters);
        obj.put("main_courses", mainCourses);
        obj.put("desserts", desserts);
        
        try {
            FileWriter file = new FileWriter("menu.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
        System.out.print(obj.toJSONString() + "\n");
    }
    
}
