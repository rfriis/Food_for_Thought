package com.example.foodforthought;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecipeFragment extends Fragment implements RecipeHolder.OnRecipeListener {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private ArrayList<Recipe> recipeArrayList;
    private TextView emptyView1;
    private TextView emptyView2;
    FloatingActionButton newRecipeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Recipes");
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        newRecipeButton = view.findViewById(R.id.newRecipeButton);
        newRecipeButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                // on add button click
               NewRecipeDialog.display(getChildFragmentManager());
            }
        });

        emptyView1 = view.findViewById(R.id.noRecipesText1);
        emptyView2 = view.findViewById(R.id.noRecipesText2);

        // set up RecyclerView
        recyclerView = view.findViewById(R.id.recipeRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recipeArrayList = new ArrayList<>();
        adapter = new RecipeAdapter(view.getContext(), recipeArrayList, this);
        recyclerView.setAdapter(adapter);
        // check if there are any recipes
        if (recipeArrayList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView1.setVisibility(View.VISIBLE);
            emptyView2.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView1.setVisibility(View.GONE);
            emptyView2.setVisibility(View.GONE);
        }
        return view;
    }

    @Override
    public void onRecipeClick(int position) {

    }
}
