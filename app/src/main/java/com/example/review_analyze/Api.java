package com.example.review_analyze;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers({"Content-Type: application/json"})
    @POST("/request")
    Call<ResponseBody> sendMessage(@Body RequestBody requestBody);
}
