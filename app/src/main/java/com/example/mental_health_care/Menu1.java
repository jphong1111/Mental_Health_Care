package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//what kind of mental health care are exist
public class Menu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);


//How ADHD Button works
        Button ADHD_Button = (Button) findViewById(R.id.button1);
        ADHD_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_ADHD = new Intent(Menu1.this,Menu1_1.class);
                startActivity(go_ADHD);

            }
        });

//How Depression Button works

        Button Panic_Button = (Button) findViewById(R.id.button2);
        Panic_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_Panic = new Intent(Menu1.this,Menu1_2.class);
                startActivity(go_Panic);
            }
        });

        //How Panic Button works
        Button Depression_Button = (Button) findViewById(R.id.button3);
        Depression_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_depression = new Intent(Menu1.this,Menu1_3.class);
                startActivity(go_depression);
            }
        });

        //How Dependence button works
        Button dependence_button = (Button) findViewById(R.id.button4);
        dependence_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dependence_button = new Intent(Menu1.this,Menu1_4.class);
                startActivity(dependence_button);
            }
        });
    }


    }

