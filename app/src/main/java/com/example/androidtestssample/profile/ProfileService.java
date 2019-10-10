package com.example.androidtestssample.profile;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfileService {

    @GET("/users/riggaroo")
    Call<ResponseBody> getProfile();

}
