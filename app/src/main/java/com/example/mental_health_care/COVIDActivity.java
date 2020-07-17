package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

                /*
                 *****************************************************************
                 * VARIABLE                                                      *
                 * content1 -> total positive                                    *
                 * content2 -> total death                                       *
                 * content3 -> positive increase                                 *
                 * content4 -> death increase                                    *
                 *****************************************************************
                 */
                //show positive data in us
                //HAVE TO FIX : this code only can show whole result of positive so that it needs to
                //change to get only one data and set to text
                for (COVID_Post_Data covid_post_data : posts) {
                    String content1,content2,content3,content4 = "";

                    content1 = covid_post_data.getPositive() + "\n";
                    content2 = covid_post_data.getDeath() + "\n";
                    content3 = " (+" + covid_post_data.getPositiveIncrease() + ")\n";
                    content4 = " (+" + covid_post_data.getDeathIncrease() + ")\n";

                    textViewResult.append(content1);
                    textViewResult2.append(content2);
                    textViewResult3.append(content3);
                    textViewResult4.append(content4);
                }

            }

            @Override
            public void onFailure(Call<List<COVID_Post_Data>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


}
