package com.mvvm_restapi_demo.ui.recipeActivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeModel {


    @SerializedName("meals")
    private List<Recipe> meals;

    public List<Recipe> getMeals() {
        return meals;
    }

    public static class Recipe {
        /**
         * strMeal : Baked salmon with fennel & tomatoes
         * strMealThumb : https://www.themealdb.com/images/media/meals/1548772327.jpg
         * idMeal : 52959
         */

        @SerializedName("strMeal")
        private String strMeal;
        @SerializedName("strMealThumb")
        private String strMealThumb;
        @SerializedName("idMeal")
        private String idMeal;

        public String getStrMeal() {
            return strMeal;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        String getIdMeal() {
            return idMeal;
        }
    }
}
