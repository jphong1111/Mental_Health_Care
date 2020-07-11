package com.example.mental_health_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mental_health_care.QuizContract.*;
import java.util.ArrayList;
import java.util.List;
public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FinalQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }
    //퀴즈들을 여기다가 추가
    //These question is from : https://www.psycom.net/depression-test/
    private void fillQuestionTable() {
        Question q1 = new Question("Feeling tired or having little energy", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q1);
        Question q2 = new Question("Poor appetite or overeating", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q2);
        Question q3 = new Question("Feeling bad about yourself - or that you are a failure or have let yourself or your family down", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q3);
        Question q4 = new Question("Trouble concentrating on things, such as reading the newspaper or watching television", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q4);
        Question q5 = new Question("Moving or speaking so slowly that other people could have noticed", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q5);
        Question q6 = new Question("Thoughts that you would be better off dead, or of hurting yourself", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q6);
        Question q7 = new Question("If you've had any days with issues above, how difficult have these problems made it for you at work, home, school, or with other people?", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q7);
        Question q8 = new Question("Little interest or pleasure in doing things", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q8);
        Question q9 = new Question("Feeling down, depressed, or hopeless", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q9);
        Question q10 = new Question("Trouble falling or staying asleep, or sleeping too much", "Not at all", "Several days", "More than half the days", "Nearly every day",1);
        addQuestion(q10);
    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}