package com.mvvm_restapi_demo.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.mvvm_restapi_demo.datasource.web.ServiceGenerator;
import com.mvvm_restapi_demo.ui.categoryActivity.CategoryModel;
import com.mvvm_restapi_demo.ui.recipeActivity.RecipeModel;
import com.mvvm_restapi_demo.ui.recipedetailActivity.RecipeDetailModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {

    //Categories list Api call
    private ArrayList<CategoryModel.Categories> categories = new ArrayList<>();
    private MutableLiveData<List<CategoryModel.Categories>> mutableLiveDataCategories = new MutableLiveData<>();

    public MutableLiveData<List<CategoryModel.Categories>> getMutableLiveDataCategories() {

        ServiceGenerator.getApi().getCategories().enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(@NonNull Call<CategoryModel> call, @NonNull Response<CategoryModel> response) {
                CategoryModel categoryModel = response.body();

                if (categoryModel != null && categoryModel.getCategories()!=null){

                    categories = (ArrayList<CategoryModel.Categories>) categoryModel.getCategories();
                    mutableLiveDataCategories.setValue(categories);

                }

            }

            @Override
            public void onFailure(@NonNull Call<CategoryModel> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });


        return mutableLiveDataCategories;
    }

    //Recipes list Api call
    private ArrayList<RecipeModel.Recipe> recipes = new ArrayList<>();
    private MutableLiveData<List<RecipeModel.Recipe>> listMutableLiveDataRecipes = new MutableLiveData<>();

    public MutableLiveData<List<RecipeModel.Recipe>> getListMutableLiveDataRecipes(String categoryName) {

        ServiceGenerator.getApi().getRecipes(categoryName).enqueue(new Callback<RecipeModel>() {
            @Override
            public void onResponse(@NonNull Call<RecipeModel> call, @NonNull Response<RecipeModel> response) {
                RecipeModel recipeModel = response.body();

                if (recipeModel != null && recipeModel.getMeals() != null) {
                    recipes = (ArrayList<RecipeModel.Recipe>) recipeModel.getMeals();
                    listMutableLiveDataRecipes.setValue(recipes);
                }
            }

            @Override
            public void onFailure(@NonNull Call<RecipeModel> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

        return listMutableLiveDataRecipes;
    }

    //Recipe detail call
    private List<RecipeDetailModel.Meals> meals;
    private MutableLiveData<List<RecipeDetailModel.Meals>> listMutableLiveDataMeals = new MutableLiveData<>();

    public MutableLiveData<List<RecipeDetailModel.Meals>> getListMutableLiveDataMeals(String mealId) {

        ServiceGenerator.getApi().getMeal(mealId).enqueue(new Callback<RecipeDetailModel>() {
            @Override
            public void onResponse(@NonNull Call<RecipeDetailModel> call, @NonNull Response<RecipeDetailModel> response) {
                RecipeDetailModel recipeDetailModel= response.body();

                if (recipeDetailModel != null && recipeDetailModel.getMeals()!=null){
                    meals = recipeDetailModel.getMeals();
                    listMutableLiveDataMeals.setValue(meals);
                }

            }

            @Override
            public void onFailure(@NonNull Call<RecipeDetailModel> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

        return listMutableLiveDataMeals;
    }
}
