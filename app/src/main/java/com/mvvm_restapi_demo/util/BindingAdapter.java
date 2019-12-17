package com.mvvm_restapi_demo.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mvvm_restapi_demo.R;

public class BindingAdapter {

    @android.databinding.BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url != null) {
            RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
            Glide.with(imageView.getContext())
                    .setDefaultRequestOptions(options)
                    .load(url)
                    .into(imageView);
        }
    }

}
