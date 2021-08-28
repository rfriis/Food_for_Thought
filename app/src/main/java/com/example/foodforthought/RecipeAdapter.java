package com.example.foodforthought;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {
    private Context context;
    private ArrayList<Recipe> recipes;
    private RecipeHolder.OnRecipeListener onRecipeListener;

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes, RecipeHolder.OnRecipeListener onRecipeListener) {
        this.context = context;
        this.recipes = recipes;
        this.onRecipeListener = onRecipeListener;
    }

    @Override
    public int getItemViewType(int position) {
//        if(recipes.isEmpty()) {
//            Log.d("RecipeDebug", "no recipes found");
//            return R.layout.no_recipes;
//        } else {
//            Log.d("RecipeDebug", "recipes found");
//            return R.layout.item_row_recipe;
//        }
        Log.d("RecipeDebug", "here we are");
        return R.layout.item_row_recipe;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecipeHolder(view, onRecipeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        holder.setDetails(recipe);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
