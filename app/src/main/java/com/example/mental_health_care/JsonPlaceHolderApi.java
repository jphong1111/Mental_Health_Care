package com.example.mental_health_care;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    //get data from json about US infection
    @GET("us/daily.json")
    Call<List<COVID_Post_Data>> get_covid_post();

    //get data from json about states infection
   @GET("states/daily.json")
    Call<List<COVID_Post_Data>> get_covid_post_state();
}
