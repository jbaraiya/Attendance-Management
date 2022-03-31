package com.rku.attendencetakingapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APISet {

    @GET("get_classwise_student")
    Call<List<GetClasswiseStudent>> getClasswiseStudent();
}
