package com.example.mental_health_care;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//menu for depression
public class Menu1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);
        final TextView myClickableUrl = (TextView) findViewById(R.id.WebSite_Text);
        myClickableUrl.setText("Visit Web site for more information:\nhttps://www.psychiatry.org/patients-families/depression/what-is-depression");
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);

        TextView sick_name = (TextView)findViewById(R.id.mental_name);
        sick_name.setText("DEPRESSION");

        TextView description = (TextView)findViewById(R.id.description);
        description.setText("Depression (major depressive disorder) is a common and serious medical" +
                " illness that negatively affects how you feel, the way you think and how you act." +
                " Fortunately, it is also treatable. Depression causes feelings of sadness and/or a " +
                "loss of interest in activities once enjoyed. It can lead to a variety of emotional " +
                "and physical problems and can decrease a person’s ability to function at work and " +
                "at home.");

        TextView description2 = (TextView)findViewById(R.id.description_2);
        description2.setText("Continued feelings of sadness or loss of interest, which are" +
                " characteristic of major depression, can even lead to behavioral and physical" +
                " symptoms. This may include changes in sleep and appetite, energy levels," +
                " concentration, daily behavior, or self-esteem. Depression can also be associated" +
                " with the idea of suicide.");


    }
}
