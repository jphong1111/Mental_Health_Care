package com.example.mental_health_care;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//menu for ADHD
public class Menu1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);

        final TextView myClickableUrl = (TextView) findViewById(R.id.WebSite_Text);
        myClickableUrl.setText("Visit Web site for more information:\nhttps://www.cdc.gov/ncbddd/adhd/facts.html");
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);

        TextView sick_name = (TextView)findViewById(R.id.mental_name);
        sick_name.setText("ADHD");

        TextView description = (TextView)findViewById(R.id.description);
        description.setText("ADHD is one of the most common neurodevelopmental disorders of childhood. It " +
                "is usually first diagnosed in childhood and often lasts into adulthood. Children with ADHD m" +
                "ay have trouble paying attention, controlling impulsive behaviors (may act without thinkin" +
                "g about what the result will be), or be overly active.");

        TextView description2 = (TextView)findViewById(R.id.description_2);
        description2.setText("It is normal for children to have trouble focusing and behaving at" +
                " one time or another. However, children with ADHD do not just grow out of these " +
                "behaviors. The symptoms continue, can be severe, and can cause difficulty at school," +
                " at home, or with friends.");
    }
}
