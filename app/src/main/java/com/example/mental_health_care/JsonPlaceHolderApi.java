package com.example.mental_health_care;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("us/daily.json")
    Call<List<COVID_Post_Data>> get_covid_post();

/*    @GET("states/daily.json")
    Call<List<COVID_Post_Data>> get_covid_post();*/
}
