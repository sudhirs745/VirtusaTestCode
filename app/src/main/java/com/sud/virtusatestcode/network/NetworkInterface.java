package com.sud.virtusatestcode.network;

import com.sud.virtusatestcode.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


public interface NetworkInterface {


    @Headers("Content-Type: application/json")
    @GET("users/{id}")
    Observable<UserResponse> getUserList(@Path("id") String id);


}
