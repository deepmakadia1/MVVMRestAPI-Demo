package com.mvvm_restapi_demo.ui.recipedetailActivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeDetailModel {

    @SerializedName("meals")
    private List<Meals> meals;

    public List<Meals> getMeals() {
        return meals;
    }

    public void setMeals(List<Meals> meals) {
        this.meals = meals;
    }

    public static class Meals {
        /**
         * idMeal : 52940
         * strMeal : Brown Stew Chicken
         * strCategory : Chicken
         * strArea : Jamaican
         * strInstructions : Squeeze lime over chicken and rub well. Drain off excess lime juice.
         Combine tomato, scallion, onion, garlic, pepper, thyme, pimento and soy sauce in a large bowl with the chicken pieces. Cover and marinate at least one hour.
         Heat oil in a dutch pot or large saucepan. Shake off the seasonings as you remove each piece of chicken from the marinade. Reserve the marinade for sauce.
         Lightly brown the chicken a few pieces at a time in very hot oil. Place browned chicken pieces on a plate to rest while you brown the remaining pieces.
         Drain off excess oil and return the chicken to the pan. Pour the marinade over the chicken and add the carrots. Stir and cook over medium heat for 10 minutes.
         Mix flour and coconut milk and add to stew, stirring constantly. Turn heat down to minimum and cook another 20 minutes or until tender.
         * strMealThumb : https://www.themealdb.com/images/media/meals/sypxpx1515365095.jpg
         * strTags : Stew
         * strYoutube : https://www.youtube.com/watch?v=_gFB1fkNhXs
         * strSource : http://www.geniuskitchen.com/recipe/authentic-jamaican-brown-stew-chicken-347996
         */

        @SerializedName("idMeal")
        private String idMeal;
        @SerializedName("strMeal")
        private String strMeal;
        @SerializedName("strCategory")
        private String strCategory;
        @SerializedName("strArea")
        private String strArea;
        @SerializedName("strInstructions")
        private String strInstructions;
        @SerializedName("strMealThumb")
        private String strMealThumb;
        @SerializedName("strTags")
        private String strTags;

        public String getStrMeal() {
            return strMeal;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public String getStrArea() {
            return strArea;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        public String getStrTags() {
            return strTags;
        }

    }
}
