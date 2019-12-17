package com.mvvm_restapi_demo.datasource.web;

import com.mvvm_restapi_demo.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static API api = retrofit.create(API.class);

    public static API getApi() {
        return api;
    }
}
