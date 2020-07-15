package com.example.mental_health_care;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_menu);

        textViewResult = findViewById(R.id.text_view_result);

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

                for (COVID_Post_Data covid_post_data : posts) {
                    String content = "";
                    content+= "Positive Increase : " + covid_post_data.getPositiveIncrease() + "\n";
                    content+= "Negative Increase : " + covid_post_data.getNegativeIncrease() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<COVID_Post_Data>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


}
