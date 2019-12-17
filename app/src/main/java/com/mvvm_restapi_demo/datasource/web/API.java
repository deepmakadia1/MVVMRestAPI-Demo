package com.mvvm_restapi_demo.datasource.web;

import com.mvvm_restapi_demo.ui.categoryActivity.CategoryModel;
import com.mvvm_restapi_demo.ui.recipeActivity.RecipeModel;
import com.mvvm_restapi_demo.ui.recipedetailActivity.RecipeDetailModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("categories.php")
    Call<CategoryModel> getCategories();

    @GET("filter.php")
    Call<RecipeModel> getRecipes(
            @Query("c") String categoryName
    );

    @GET("lookup.php")
    Call<RecipeDetailModel> getMeal(
            @Query("i") String mealId
    );

}
