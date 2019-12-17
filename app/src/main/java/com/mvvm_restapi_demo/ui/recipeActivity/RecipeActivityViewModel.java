package com.mvvm_restapi_demo.ui.recipeActivity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mvvm_restapi_demo.repositories.RecipeRepository;

import java.util.List;

public class RecipeActivityViewModel extends AndroidViewModel {
    private RecipeRepository recipeRepository;

    public RecipeActivityViewModel(@NonNull Application application) {
        super(application);
        recipeRepository = new RecipeRepository();
    }

    LiveData<List<RecipeModel.Recipe>> getMeals(String categoryName){
        return recipeRepository.getListMutableLiveDataRecipes(categoryName);
    }

}
