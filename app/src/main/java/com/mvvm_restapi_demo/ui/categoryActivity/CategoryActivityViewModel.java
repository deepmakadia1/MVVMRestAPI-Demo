package com.mvvm_restapi_demo.ui.categoryActivity;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mvvm_restapi_demo.repositories.RecipeRepository;

import java.util.List;

public class CategoryActivityViewModel extends AndroidViewModel {
    private RecipeRepository recipeRepository;
    public CategoryActivityViewModel(@NonNull Application application) {
        super(application);
        recipeRepository = new RecipeRepository();
    }

    LiveData<List<CategoryModel.Categories>> getAllCategories(){

        return recipeRepository.getMutableLiveDataCategories();

    }
}
