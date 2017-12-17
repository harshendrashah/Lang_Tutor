package com.shah.langtutor.Marathi;

import com.shah.langtutor.R;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MarathiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marathi);

        //Find View that shows Alphabets Category
        TextView marathiAlphabets = (TextView) findViewById(R.id.marathi_alphabets);

        //Set a ClickListener on that View
        marathiAlphabets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link MarathiAlphabetsActivity}
                Intent mAlphabets = new Intent(MarathiActivity.this, MarathiAlphabetsActivity.class);

                //Start the new Activity;
                startActivity(mAlphabets);
            }
        });
        //Find View that shows Numbers Category
        TextView marathiNumbers = (TextView) findViewById(R.id.marathi_numbers);

        //Set a ClickListener on that View
        marathiNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link MarathiNumbersActivity}
                Intent mNumbers = new Intent(MarathiActivity.this, MarathiNumbersActivity.class);

                //Start the new Activity;
                startActivity(mNumbers);
            }
        });

        //Find View that shows Colors Category
        TextView marathiColors = (TextView) findViewById(R.id.marathi_colors);

        //Set a ClickListener on that View
        marathiColors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link MarathiColorsActivity}
                Intent mColors = new Intent(MarathiActivity.this, MarathiColorsActivity.class);

                //Start the new Activity;
                startActivity(mColors);
            }
        });

        //Find View that shows Phrases Category
        TextView marathiPhrases = (TextView) findViewById(R.id.marathi_phrases);

        //Set a ClickListener on that View
        marathiPhrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link MarathiPhrasesActivity}
                Intent mPhrases = new Intent(MarathiActivity.this, MarathiPhrasesActivity.class);

                //Start the new Activity;
                startActivity(mPhrases);
            }
        });
    }

}
