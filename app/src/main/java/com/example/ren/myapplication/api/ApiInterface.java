package com.example.ren.myapplication.api;

import com.example.ren.myapplication.model.ModelDetail;
import com.example.ren.myapplication.model.ModelPopular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by ren on 1/5/2018.
 */

public interface ApiInterface {
    @GET("popular?api_key=4248416ea8ece743cc23ed642ba5fa00&language=en-US&page=1")
    Call<ModelPopular> getPopular();
    @GET("{movie_id}?api_key=4248416ea8ece743cc23ed642ba5fa00&language=en-US")
    Call<ModelDetail> getDetail(@Path("movie_id") int movie_id);
}
