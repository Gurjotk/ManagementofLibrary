package com.example.managementoflibrary;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("/but2")
    Call<Void> executeregister(@Body HashMap<String, String> map);

    @POST("/but4")
    Call<Void> executelogin(@Body HashMap<String, String> map);
}
