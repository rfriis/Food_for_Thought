package com.example.foodforthought;

public class Recipe {
    private int ID;
    private String name;
    private String description;
    private String cookTime;
    private Tag[] tags;
    private RecipeIngredient[] recipeIngredients;
    private Step[] steps;

    public Recipe(int ID, String name, String description, String cookTime, Tag[] tags, RecipeIngredient[] recipeIngredients, Step[] steps) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cookTime = cookTime;
        this.tags = tags;
        this.recipeIngredients = recipeIngredients;
        this.steps = steps;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCookTime() { return cookTime; }

    public void setCookTime(String cookTime) { this.cookTime = cookTime; }

    public Tag[] getTags() {
        Tag[] tagCopy = new Tag[this.tags.length];
        System.arraycopy(this.tags, 0, tagCopy, 0, tagCopy.length);
        return tagCopy;
    }

    public void setTags(Tag[] tags) {
        this.tags = new Tag[tags.length];
        System.arraycopy(tags, 0, this.tags, 0, tags.length);
    }

    public RecipeIngredient[] getRecipeIngredients() {
        RecipeIngredient[] recipeIngredientCopy = new RecipeIngredient[this.recipeIngredients.length];
        System.arraycopy(this.recipeIngredients, 0, recipeIngredientCopy, 0, recipeIngredientCopy.length);
        return recipeIngredientCopy;
    }

    public void setRecipeIngredients(RecipeIngredient[] recipeIngredients) {
        this.recipeIngredients = new RecipeIngredient[recipeIngredients.length];
        System.arraycopy(recipeIngredients, 0, this.recipeIngredients, 0, recipeIngredients.length);
    }

    public Step[] getSteps() {
        Step[] stepCopy = new Step[this.steps.length];
        System.arraycopy(this.steps, 0, stepCopy, 0, stepCopy.length);
        return stepCopy;
    }

    public void setSteps(Step[] steps) {
        this.steps = new Step[steps.length];
        System.arraycopy(steps, 0, this.steps, 0, steps.length);
    }
}
