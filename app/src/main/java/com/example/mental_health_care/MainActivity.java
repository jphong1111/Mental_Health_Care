package com.example.mental_health_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//icon picture is from : Icons made by <a href="http://www.freepik.com/" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //How Button1 works
        Button Sub1_Button = (Button) findViewById(R.id.button1);
        Sub1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub1Activity (Screen Transition)
                Intent move_main_sub1 = new Intent(MainActivity.this,Menu1.class);
                startActivity(move_main_sub1);
            }
        });

        //How Button2 works
        Button Sub2_Button = (Button) findViewById(R.id.button2);
        Sub2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub2Activity (Screen Transition)
                Intent move_main_sub2 = new Intent(MainActivity.this,Menu2.class);
                startActivity(move_main_sub2);
            }
        });

        //How Button3 works
        Button Sub3_Button = (Button) findViewById(R.id.button3);
        Sub3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub3Activity (Screen Transition)
                Intent move_main_sub3 = new Intent(MainActivity.this,Menu3.class);
                startActivity(move_main_sub3);
            }
        });

        //How Button4 works
        Button Sub4_Button = (Button) findViewById(R.id.button4);
        Sub4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub4Activity (Screen Transition)
                Intent move_main_sub4 = new Intent(MainActivity.this,Menu4.class);
                startActivity(move_main_sub4);
            }
        });

        //How COVID_Button works
        Button Sub5_Button = (Button) findViewById(R.id.covid_button);
        Sub5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Su54Activity (Screen Transition)
                Intent move_main_sub5 = new Intent(MainActivity.this,COVIDActivity.class);
                startActivity(move_main_sub5);
            }
        });
    }



}
