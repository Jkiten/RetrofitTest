package com.example.apitest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static Retrofit retrofit;

    public static Retrofit getClient(){
        retrofit= new Retrofit.Builder()
                .baseUrl("http://192.168.219.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}

//    CREATE TABLE USER(
//        UID INT PRIMARY KEY,
//        ID VARCHAR(127),
//    PW VARCHAR(32),
//    NAME VARCHAR(127),
//    SCORE INT
//)
