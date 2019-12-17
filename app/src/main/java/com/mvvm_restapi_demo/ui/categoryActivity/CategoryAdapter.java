package com.mvvm_restapi_demo.ui.categoryActivity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvvm_restapi_demo.R;
import com.mvvm_restapi_demo.databinding.ItemCategoryBinding;
import com.mvvm_restapi_demo.ui.recipeActivity.RecipeActivity;
import com.mvvm_restapi_demo.util.Constants;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryModel.Categories> categories;
    private Context context;

    CategoryAdapter(Context context,List<CategoryModel.Categories> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        CategoryHolder categoryHolder = (CategoryHolder) viewHolder;

        categoryHolder.itemCategoryBinding.setCategory(categories.get(i));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    private class CategoryHolder extends RecyclerView.ViewHolder{

        ItemCategoryBinding itemCategoryBinding;

        CategoryHolder(@NonNull View itemView) {
            super(itemView);

            itemCategoryBinding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,RecipeActivity.class)
                    .putExtra(Constants.CATEGORY_NAME,categories.get(getAdapterPosition()).getStrCategory()));
                }
            });

        }
    }

}
