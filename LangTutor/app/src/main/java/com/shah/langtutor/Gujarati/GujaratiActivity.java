package com.shah.langtutor.Gujarati;

import com.shah.langtutor.R;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GujaratiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujarati);

        //Find View that shows Alphabets Category
        TextView gujaratiAlphabets = (TextView) findViewById(R.id.gujarati_alphabets);

        //Set a ClickListener on that View
        gujaratiAlphabets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiAlphabetsActivity}
                Intent gAlphabets = new Intent(GujaratiActivity.this, GujaratiAlphabetsActivity.class);

                //Start the new Activity;
                startActivity(gAlphabets);
            }
        });
        //Find View that shows Numbers Category
        TextView gujaratiNumbers = (TextView) findViewById(R.id.gujarati_numbers);

        //Set a ClickListener on that View
        gujaratiNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiNumbersActivity}
                Intent gNumbers = new Intent(GujaratiActivity.this, GujaratiNumbersActivity.class);

                //Start the new Activity;
                startActivity(gNumbers);
            }
        });

        //Find View that shows Colors Category
        TextView gujaratiColors = (TextView) findViewById(R.id.gujarati_colors);

        //Set a ClickListener on that View
        gujaratiColors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiColorsActivity}
                Intent gColors = new Intent(GujaratiActivity.this, GujaratiColorsActivity.class);

                //Start the new Activity;
                startActivity(gColors);
            }
        });

        //Find View that shows Phrases Category
        TextView gujaratiPhrases = (TextView) findViewById(R.id.gujarati_phrases);

        //Set a ClickListener on that View
        gujaratiPhrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiPhrasesActivity}
                Intent gPhrases = new Intent(GujaratiActivity.this, GujaratiPhrasesActivity.class);

                //Start the new Activity;
                startActivity(gPhrases);
            }
        });

    }

}
