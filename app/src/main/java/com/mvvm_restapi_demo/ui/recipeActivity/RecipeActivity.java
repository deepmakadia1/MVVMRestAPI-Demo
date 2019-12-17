package com.mvvm_restapi_demo.ui.recipeActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mvvm_restapi_demo.R;
import com.mvvm_restapi_demo.databinding.ActivityRecipeBinding;
import com.mvvm_restapi_demo.util.Constants;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private ActivityRecipeBinding binding;
    private RecipeActivityViewModel recipeActivityViewModel;
    private List<RecipeModel.Recipe> meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recipe);

        recipeActivityViewModel = ViewModelProviders.of(this).get(RecipeActivityViewModel.class);

        getRecipes();

    }

    private void getRecipes() {

        recipeActivityViewModel.getMeals(getIntent().getStringExtra(Constants.CATEGORY_NAME)).observe(this, new Observer<List<RecipeModel.Recipe>>() {
            @Override
            public void onChanged(@Nullable List<RecipeModel.Recipe> recipeLive) {
                meals = recipeLive;
                setRecyclerView();
            }
        });

    }

    private void setRecyclerView() {

        RecipeAdapter recipeAdapter = new RecipeAdapter(this,meals);
        binding.listRecipe.setLayoutManager(new LinearLayoutManager(this));
        binding.listRecipe.setAdapter(recipeAdapter);

    }
}
