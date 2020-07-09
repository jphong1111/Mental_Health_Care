package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu2_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2_2);

        Button button_to_menu = findViewById(R.id.go_home);

        //홈으로
        button_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub1Activity (Screen Transition)
                Intent move_to_main = new Intent(Menu2_2.this,MainActivity.class);
                startActivity(move_to_main);
            }
        });

        //show test result







    }


}
