package com.mvvm_restapi_demo.ui.categoryActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mvvm_restapi_demo.R;
import com.mvvm_restapi_demo.databinding.ActivityCategoryBinding;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private CategoryActivityViewModel categoryActivityViewModel;
    private List<CategoryModel.Categories> categories;
    private ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_category);

        categoryActivityViewModel = ViewModelProviders.of(this).get(CategoryActivityViewModel.class);

        getCategories();

    }

    private void getCategories() {

        categoryActivityViewModel.getAllCategories().observe(CategoryActivity.this, new Observer<List<CategoryModel.Categories>>() {
            @Override
            public void onChanged(@Nullable List<CategoryModel.Categories> categoriesLive) {
                categories = categoriesLive;
                serRecyclerView();
            }
        });

    }

    private void serRecyclerView() {

        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categories);
        binding.listCategory.setLayoutManager(new LinearLayoutManager(this));
        binding.listCategory.setAdapter(categoryAdapter);

    }
}
