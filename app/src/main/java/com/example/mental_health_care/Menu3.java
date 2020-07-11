package com.example.mental_health_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//Chatting View  about mental health
public class Menu3 extends AppCompatActivity {


    private int level = 1;
    TextView questionView;
    Button button1;
    Button button2;
    Button button3;


    public int getLevel(){

        return level;
    }

    public void setLevel(int level){

        this.level = level;
    }

    public int levelup(){

        level = level + 1;

        return level;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu3);


        questionView =  (TextView) findViewById(R.id.questionBoard);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        EditText Edittext1 = (EditText) findViewById(R.id.textBox);









        button1.setOnClickListener(new View.OnClickListener() {

            //            Level은 올라간다.
            @Override
            public void onClick(View v) {
                level++;
                setLevel(level);
                Toast.makeText(getApplicationContext(),Integer.toString(getLevel()) ,Toast.LENGTH_SHORT).show();
                changeQeustion(level);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                level++;
                setLevel(level);
                changeQeustion(level);


            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level++;
                setLevel(level);
                changeQeustion(level);

            }
        });


//       First Question
        questionView.setText("My name is Joy, How are you doing Today? \n Choose the one of the emotion words below");
        button1.setText("I don't have power today");
        button2.setText("I am despressed");
        button3.setText("I am sad");




    }

    public void changeQeustion(int update) {

        switch(update){


            case 1 :

                questionView.setText("My name is Joy, How are you doing Today? \n Choose the one of the emotion words below");

                break;

            case 2 :
                questionView.setText("It's important to know how i feel, can you tell me what happened at that time");
                button1.setVisibility(View.GONE);
                button1.setText("I argued with my friend");
                button2.setText("I got a bad grade");
                button3.setText("I am tired");

                break;

            case 3 : questionView.setText("I am always with you \n please don't hesitate contact with me" );
                button1.setText("I need help");
                button2.setText("Thank you");
                button3.setVisibility(View.GONE);
                break;



            default: questionView.setText("Thank you for helping me, \n I am so glad to help you");

        }

    }





}