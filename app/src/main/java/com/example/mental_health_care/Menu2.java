package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

//self diagnose test about mental health
public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }

        });

        ImageButton buttonGoBack = findViewById(R.id.go_back);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Menu2.this,MainActivity.class);
                startActivity(back);
            }

        });
    }


    private void startQuiz() {
    Intent intent = new Intent(Menu2.this,Menu2_1.class);
    startActivity(intent);
    }
}
