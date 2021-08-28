package com.example.foodforthought;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView recipeID, recipeName, recipeDescription, recipeCookTime;
    OnRecipeListener onRecipeListener;

    public RecipeHolder(View itemView, OnRecipeListener onRecipeListener) {
        super(itemView);
        recipeID = itemView.findViewById(R.id.recipeID);
        recipeName = itemView.findViewById(R.id.recipeName);
        recipeDescription = itemView.findViewById(R.id.recipeDescription);
        recipeCookTime = itemView.findViewById(R.id.recipeCookTime);
        this.onRecipeListener = onRecipeListener;
        itemView.setOnClickListener(this);
    }

    public void setDetails(Recipe recipe) {
        recipeID.setText(String.valueOf(recipe.getID()));
        recipeName.setText(recipe.getName());
        recipeDescription.setText(recipe.getDescription());
        recipeCookTime.setText(recipe.getCookTime());
    }

    @Override
    public void onClick(View v) { onRecipeListener.onRecipeClick(getAdapterPosition()); }

    public interface OnRecipeListener {
        void onRecipeClick(int position);
    }

}
