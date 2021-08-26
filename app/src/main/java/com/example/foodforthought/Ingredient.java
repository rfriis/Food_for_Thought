package com.example.foodforthought;

public class Ingredient {
    private int ID;
    private String name;
    private String unit;

    public Ingredient(int ID, String name, String unit) {
        this.ID = ID;
        this.name = name;
        this.unit = unit;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }
}
