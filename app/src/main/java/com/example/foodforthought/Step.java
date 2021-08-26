package com.example.foodforthought;

public class Step {
    private int ID;
    private int order;
    private String description;
    private int recipeID;

    public Step(int ID, int order, String description, int recipeID) {
        this.ID = ID;
        this.order = order;
        this.description = description;
        this.recipeID = recipeID;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public int getOrder() { return order; }

    public void setOrder(int order) { this.order = order; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getRecipeID() { return recipeID; }

    public void setRecipeID(int recipeID) { this.recipeID = recipeID; }
}
