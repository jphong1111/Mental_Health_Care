package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu2_2 extends AppCompatActivity {

    private TextView textViewResult;
    private int result_score = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2_2);


        if(result_score == 1) {
            showNextResult("Your answers suggest that you have some of the same symptoms common " +
                    "in people suffering from depression. Since this quiz is not meant to replace " +
                    "a professional diagnosis, you should follow up with your doctor or a mental" +
                    " health worker for an assessment.");
        }
        else {

            showNextResult("test2");
        }

        Button button_to_menu = (Button) findViewById(R.id.go_home);
        button_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to next Sub3Activity (Screen Transition)
                Intent move_to_main = new Intent(Menu2_2.this,MainActivity.class);
                startActivity(move_to_main);
            }
        });

        //show test result







    }

private void showNextResult(String result) {

    textViewResult = findViewById(R.id.test_result);
    textViewResult.setText(result);

    }
}
