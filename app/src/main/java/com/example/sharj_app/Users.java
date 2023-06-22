package com.example.sharj_app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Users {

    @POST("Inquiry/FixedLineBillInquiry")
    Call<FinalTerm> saveUser();


    @POST(".")
    Call<ChargeResponse> getCharge(@Body RequestCharge requestCharge);
}
