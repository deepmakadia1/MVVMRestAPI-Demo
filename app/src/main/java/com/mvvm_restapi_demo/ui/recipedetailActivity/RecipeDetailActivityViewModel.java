package com.mvvm_restapi_demo.ui.recipedetailActivity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mvvm_restapi_demo.repositories.RecipeRepository;

import java.util.List;

public class RecipeDetailActivityViewModel extends AndroidViewModel {
    private RecipeRepository recipeDetailRepository;
    public RecipeDetailActivityViewModel(@NonNull Application application) {
        super(application);
        recipeDetailRepository = new RecipeRepository();
    }

    LiveData<List<RecipeDetailModel.Meals>> getMeal(String mealId){
        return recipeDetailRepository.getListMutableLiveDataMeals(mealId);
    }
}
