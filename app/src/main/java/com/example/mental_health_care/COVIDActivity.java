package com.example.mental_health_care;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.lang.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class COVIDActivity extends AppCompatActivity {
    private TextView textViewResult;
    private TextView textViewResult2;
    private TextView textViewResult3;
    private TextView textViewResult4;
    private TextView textViewResult5;

    private static final String TAG = "COVIDActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_menu);
        //How go_back_button works
        ImageButton bo_back_Button = (ImageButton) findViewById(R.id.covid_to_main);
        bo_back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent move_main_covid = new Intent(COVIDActivity.this,MainActivity.class);
                startActivity(move_main_covid);
            }
        });

        textViewResult = findViewById(R.id.text_view_result_positive);
        textViewResult2 = findViewById(R.id.text_view_result_death);
        textViewResult3 = findViewById(R.id.text_view_result_positive_increase);
        textViewResult4 = findViewById(R.id.text_view_result_death_increase);
        textViewResult5 = findViewById(R.id.today_date);
        //Gson set date format BUT NEVER USED
        Gson date = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        //build retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covidtracking.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<COVID_Post_Data>> call = jsonPlaceHolderApi.get_covid_post();

        call.enqueue(new Callback<List<COVID_Post_Data>>() {
            @Override
            public void onResponse(Call<List<COVID_Post_Data>> call, Response<List<COVID_Post_Data>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText(("Code: " + response.code()));
                    return;

                }
                List<COVID_Post_Data> posts = response.body();

                //Give message if fail, TAG is COVIDActivity so that it will show log in this activity
                if(posts == null) {
                    Log.w(TAG,"Did not receive any valid response body");
                    return;
                }


                /*
                 *****************************************************************
                 * VARIABLE                                                      *
                 * content1 -> total positive                                    *
                 * content2 -> total death                                       *
                 * content3 -> positive increase                                 *
                 * content4 -> death increase                                    *
                 * content5 -> today's date                                      *
                 *****************************************************************
                 */
                //show positive data in us
                //HAVE TO FIX : this code only can show whole result of positive so that it needs to
                //change to get only one data and set to text
                //get information about whole infection in US
                for (COVID_Post_Data covid_post_data : posts) {
                    String content1,content2,content3,content4,content5 = "";

                    content1 = covid_post_data.getPositive() + "\n";
                    content2 = covid_post_data.getDeath() + "\n";
                    content3 = " (+" + covid_post_data.getPositiveIncrease() + ")\n";
                    content4 = " (+" + covid_post_data.getDeathIncrease() + ")\n";
                    content5 = " Updated : " + covid_post_data.getDate() + "\n";
                    /*Try to put formatted date data BUT FAILED
                    content5 = date.toJson(covid_post_data.getDateChecked());*/
                    textViewResult.append(content1);
                    textViewResult2.append(content2);
                    textViewResult3.append(content3);
                    textViewResult4.append(content4);
                    textViewResult5.append(content5);

                }





            }

            @Override
            public void onFailure(Call<List<COVID_Post_Data>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


}
