package com.example.mental_health_care;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

//Give information about test
public class Menu2_1 extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewQuestionCount;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonconfirmnext;
    private int questionCountTotal;
    private boolean answered;
    private int questionCounter;
    private Question currentQuestion;
    private List<Question> questionList;
    private int count = 0;
    //for test score
    public int num;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2_1);

        //퀴즈와 퀴즈갯수
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.select_button1);
        rb2 = findViewById(R.id.select_button2);
        rb3 = findViewById(R.id.select_button3);
        rb4 = findViewById(R.id.select_button4);
        buttonconfirmnext = findViewById(R.id.button_confirm_next);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();

        questionCountTotal = questionList.size();
        /*셔플을 원한다면 이 옵션을 사용
        Collections.shuffle(questionList);*/
        showNextQuestion();
        buttonconfirmnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                   if (!answered) {


                          if(rb1.isChecked()){

                              showNextQuestion();
                              count++;
                          } else if(rb2.isChecked()){
                              num++;

                              showNextQuestion();
                              count++;


                          } else if(rb3.isChecked()){
                              num = num+2;

                              showNextQuestion();
                              count++;


                          }
                          else if (rb4.isChecked()) {
                              num = num + 3;

                              showNextQuestion();
                              count++;

                          }else {
                           Toast.makeText(Menu2_1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                       }

                   } else {

                       showNextQuestion();

                   }
                if(count == questionList.size()) {
                    Intent move_to_result = new Intent(Menu2_1.this,Menu2_2.class);
                    startActivity(move_to_result);
                }


            }

        });
    }
/*    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Score: " + score);
        }
        showSolution();
    }*/

    private void showNextQuestion() {
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonconfirmnext.setText("Next");
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        finish();
    }

    public int getNum() {
        return this.num;
    }
}
