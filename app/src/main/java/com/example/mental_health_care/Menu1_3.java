package com.example.mental_health_care;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//menu for panic
public class Menu1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);
        final TextView myClickableUrl = (TextView) findViewById(R.id.WebSite_Text);
        myClickableUrl.setText("Visit Web site for more information:\nhttps://www.mayoclinic.org/diseases-conditions/panic-attacks/symptoms-causes/syc-20376021");
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);

        TextView sick_name = (TextView)findViewById(R.id.mental_name);
        sick_name.setText("PANIC");

        TextView description = (TextView)findViewById(R.id.description);
        description.setText("DA panic attack is a sudden episode of intense fear that triggers " +
                "severe physical reactions when there is no real danger or apparent cause. Panic " +
                "attacks can be very frightening. When panic attacks occur, you might think you're " +
                "losing control, having a heart attack or even dying.");

        TextView description2 = (TextView)findViewById(R.id.description_2);
        description2.setText("Panic attacks typically begin suddenly, without warning. They " +
                "can strike at any time — when you're driving a car, at the mall, sound asleep or" +
                " in the middle of a business meeting. You may have occasional panic attacks, or " +
                "they may occur frequently." +
                "Panic attacks have many variations, but symptoms usually peak within minutes. " +
                "You may feel fatigued and worn out after a panic attack subsides.");


    }
}
