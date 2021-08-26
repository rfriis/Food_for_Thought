package com.example.foodforthought;

public class Recipe {
    private int ID;
    private String name;
    private String description;
    private String cookTime;

    public Recipe(int ID, String name, String description, String cookTime) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCookTime() { return cookTime; }

    public void setCookTime(String cookTime) { this.cookTime = cookTime; }
}
