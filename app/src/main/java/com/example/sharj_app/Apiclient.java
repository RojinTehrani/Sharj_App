package com.example.sharj_app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private static Retrofit getRetrofit(){
        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("https://charge.sep.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static Users getUsers(){
        Users users=getRetrofit().create(Users.class);
        return users;
    }
}
