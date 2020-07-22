package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robinhood.spark.SparkAdapter;
import com.robinhood.spark.SparkView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class COVIDActivity extends AppCompatActivity {
    private TextView textViewResult;
    private TextView textViewResult2;
    private TextView textViewResult3;
    private TextView textViewResult4;
    private TextView textViewResult5;
    private TextView scrubInfoTextView;
    private static final String TAG = "COVIDActivity";

    //make array for datas
    private int[] covid_positive;
    private int[] covid_positive_increase;
    private int[] covid_death;
    private int[] covid_death_increase;
    private int[] covid_date;

    //Make reversed array for graph
    private int[] reversed_covid_positive;
    private int temp;

    //Adapter for graph
    private MyAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_menu);
        //How go_back_button works
        ImageButton bo_back_Button = (ImageButton) findViewById(R.id.covid_to_main);
        bo_back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent move_main_covid = new Intent(COVIDActivity.this, MainActivity.class);
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
                if (posts == null) {
                    Log.w(TAG, "Did not receive any valid response body");
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
                //HAVE TO FIX (FIXED) : this code only can show whole result of positive so that it needs to
                //change to get only one data and set to text
                //get information about whole infection in US

                int i = 0;
                covid_positive = new int[posts.size()];
                covid_positive_increase = new int[posts.size()];
                covid_date = new int[posts.size()];
                covid_death = new int[posts.size()];
                covid_death_increase = new int[posts.size()];

                for (COVID_Post_Data covid_post_data : posts) {
                    int content1, content2, content3, content4, content5;

                    //get data to contents
                    content1 = covid_post_data.getPositive();
                    content2 = covid_post_data.getDeath();
                    content3 = covid_post_data.getPositiveIncrease();
                    content4 = covid_post_data.getDeathIncrease();
                    content5 = covid_post_data.getDate();

                    //set data to each array
                    covid_death[i] = content1;
                    covid_death_increase[i] = content2;
                    covid_positive[i] = content3;
                    covid_positive_increase[i] = content4;
                    covid_date[i] = content5;
                    i++;

                    //use set text to show each data
                    textViewResult.setText(String.valueOf(covid_death[0]));
                    textViewResult2.setText(String.valueOf(covid_death_increase[0]));
                    textViewResult3.setText(String.valueOf(covid_positive[0]));
                    textViewResult4.setText(String.valueOf(covid_positive_increase[0]));
                    textViewResult5.setText(String.valueOf(covid_date[0]));


                }

                /*
                 *****************************************************************
                 *Get Spark Graph to show the positive with time sequence        *
                 *****************************************************************
                 */
                //make it reversed
                for (int j = 0; j < covid_positive.length / 2; j++) {
                    temp = covid_positive[j];
                    covid_positive[j] = covid_positive[covid_positive.length - j - 1];
                    covid_positive[covid_positive.length - j - 1] = temp;

                }
                //Set to revered covid positive array
                reversed_covid_positive = covid_positive;
                scrubInfoTextView = findViewById(R.id.scrub_info_textview);
                SparkView sparkView = (SparkView) findViewById(R.id.sparkview);

                //create adapter
                //put
                myadapter = new MyAdapter(reversed_covid_positive);
                sparkView.setAdapter(myadapter);
                sparkView.setScrubEnabled(true);

                sparkView.setScrubListener(new SparkView.OnScrubListener() {
                    @Override
                    public void onScrubbed(Object value) {
                        if (value == null) {
                            scrubInfoTextView.setText(R.string.scrub_empty);
                        } else {
                            scrubInfoTextView.setText(getString(R.string.scrub_format, value));

                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<COVID_Post_Data>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }


        });


    }

    //Adapter for Spark Chart
    public class MyAdapter extends SparkAdapter {

        private final int[] yData;

        public MyAdapter(int[] data) {
            this.yData = data;

        }


        @Override
        public int getCount() {
            return yData.length;
        }

        @NonNull
        @Override
        public Object getItem(int index) {
            return yData[index];
        }

        @Override
        public float getY(int index) {
            return yData[index];
        }


    }
}
