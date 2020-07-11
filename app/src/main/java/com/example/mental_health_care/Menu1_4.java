package com.example.mental_health_care;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//menu for panic
public class Menu1_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);
        final TextView myClickableUrl = (TextView) findViewById(R.id.WebSite_Text);
        myClickableUrl.setText("Visit Web site for more information:\nhttps://www.healthline.com/health/drug-dependence");
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);

        TextView sick_name = (TextView)findViewById(R.id.mental_name);
        sick_name.setText("DEPENDENCE");

        TextView description = (TextView)findViewById(R.id.description);
        description.setText("Drug dependence occurs when you need one or more drugs to function." +
                " The American Psychiatric Association (APA) used to distinguish between dependence" +
                " and abuse. Abuse was considered the mild or early phase of inappropriate drug use " +
                "that led to dependence. People viewed dependence as a more severe problem than abuse.");

        TextView description2 = (TextView)findViewById(R.id.description_2);
        description2.setText("You can often determine if an addiction has turned into dependence by" +
                " looking at behavior. When a person addicted to drugs hasn’t had them for a period " +
                "of time, this can cause a physical reaction. Physical symptoms of withdrawal occur " +
                "when the body becomes stressed without the drug. ");


    }
}
