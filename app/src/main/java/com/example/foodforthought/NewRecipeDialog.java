package com.example.foodforthought;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class NewRecipeDialog extends DialogFragment {

    private static final String TAG = "newRecipeDialog";

    private Toolbar toolbar;

    public static NewRecipeDialog display(FragmentManager fragmentManager) {
        NewRecipeDialog newRecipeDialog = new NewRecipeDialog();
        newRecipeDialog.show(fragmentManager, TAG);
        return newRecipeDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_FoodForThought_FullScreenDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.Slide);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.new_recipe_dialog, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle("New Recipe");
        toolbar.inflateMenu(R.menu.save_recipe);
        toolbar.setOnMenuItemClickListener(item -> {
            dismiss();
            return true;
        });
        Spinner cookTimeSpinner = view.findViewById(R.id.cookTimeSpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.cookTimeSpinner, android.R.layout.simple_spinner_dropdown_item);
        cookTimeSpinner.setAdapter(spinnerAdapter);
    }
}




    // create new recipe dialog
//    Dialog recipeDialog = new Dialog(getActivity());
//                recipeDialog.setTitle("Add a new Recipe");
//                        recipeDialog.setContentView(R.layout.new_recipe_dialog);
//                        recipeDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//                        recipeDialog.show();
//                        // set up toolbar
//                        Toolbar toolbar = recipeDialog.findViewById(R.id.toolbar);
//                        toolbar.setNavigationOnClickListener(v1 -> recipeDialog.dismiss());
//                        toolbar.setTitle("New Recipe");
//                        toolbar.inflateMenu(R.menu.save_recipe);
//                        toolbar.setOnMenuItemClickListener(item -> {
//                        recipeDialog.dismiss();
//                        return true;
//                        });
//                        // set spinner options
//                        Spinner cookTimeSpinner = recipeDialog.findViewById(R.id.cookTimeSpinner);
//                        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(recipeDialog.getContext(), R.array.cookTimeSpinner, android.R.layout.simple_spinner_dropdown_item);
//        cookTimeSpinner.setAdapter(spinnerAdapter);
