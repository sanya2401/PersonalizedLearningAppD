package com.example.personalizedlearningapp.api;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {
    @GET("courses")
    Call<List<String>> getCourses();
    @GET("products/categories")
    Call<List<String>> getDummyCourses();

}
