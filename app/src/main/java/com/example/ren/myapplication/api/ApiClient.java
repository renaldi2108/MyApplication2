package com.example.ren.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ren on 1/5/2018.
 */

public class ApiClient {
    public static final String BASE_URL="https://api.themoviedb.org/3/movie/";
    public static Retrofit retrofit=null;
    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
