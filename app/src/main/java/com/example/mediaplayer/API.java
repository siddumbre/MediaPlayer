package com.example.mediaplayer;

import com.example.mediaplayer.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("users")
    Call<List<Model>> getmodels();
}
