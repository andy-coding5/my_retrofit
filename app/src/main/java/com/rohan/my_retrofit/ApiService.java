package com.rohan.my_retrofit;

import com.rohan.my_retrofit.pojo.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("APIKEY:6815ab00be4c46b597b1567db6cb3def")
    @POST("user/login/")
    @FormUrlEncoded
    Call<Login> getMyJSON(@Field("email_or_phone") String email_or_phone, @Field("password") String password);
}
