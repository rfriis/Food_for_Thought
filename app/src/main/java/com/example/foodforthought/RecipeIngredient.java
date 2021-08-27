package com.example.foodforthought;

public class RecipeIngredient {
    private int recipeID;
    private int ingredientID;
    private int amount;
    private String preparation;

    public RecipeIngredient(int recipeID, int ingredientID, int amount, String preparation) {
        this.recipeID = recipeID;
        this.ingredientID = ingredientID;
        this.amount = amount;
        this.preparation = preparation;
    }

    public int getRecipeID() { return recipeID; }

    public void setRecipeID(int recipeID) { this.recipeID = recipeID; }

    public int getIngredientID() { return ingredientID; }

    public void setIngredientID(int ingredientID) { this.ingredientID = ingredientID; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public String getPreparation() { return preparation; }

    public void setPreparation(String preparation) { this.preparation = preparation; }
}
