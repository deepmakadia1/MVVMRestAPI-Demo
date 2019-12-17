package com.mvvm_restapi_demo.ui.recipedetailActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvvm_restapi_demo.R;
import com.mvvm_restapi_demo.databinding.ActivityRecipeDetailBinding;
import com.mvvm_restapi_demo.util.Constants;

import java.util.List;

public class RecipeDetailActivity extends AppCompatActivity {

    private ActivityRecipeDetailBinding binding;
    private RecipeDetailModel.Meals meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recipe_detail);

        RecipeDetailActivityViewModel recipeDetailActivityViewModel = ViewModelProviders.of(this).get(RecipeDetailActivityViewModel.class);

        recipeDetailActivityViewModel.getMeal(getIntent().getStringExtra(Constants.MEAL_ID)).observe(this, new Observer<List<RecipeDetailModel.Meals>>() {
            @Override
            public void onChanged(@Nullable List<RecipeDetailModel.Meals> mealsLive) {
                if (mealsLive != null) {
                    meals = mealsLive.get(0);
                    binding.setMeal(meals);
                }
            }
        });



    }


}
