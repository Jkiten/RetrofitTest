package com.example.apitest;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("users")
    Call<JsonArray> getUsers();
}

