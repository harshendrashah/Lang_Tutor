package com.shah.langtutor.French;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.shah.langtutor.Gujarati.GujaratiActivity;
import com.shah.langtutor.Gujarati.GujaratiAlphabetsActivity;
import com.shah.langtutor.Gujarati.GujaratiColorsActivity;
import com.shah.langtutor.Gujarati.GujaratiNumbersActivity;
import com.shah.langtutor.Gujarati.GujaratiPhrasesActivity;
import com.shah.langtutor.R;

public class FrenchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        //Find View that shows Alphabets Category
        TextView frenchAlphabets = (TextView) findViewById(R.id.french_alphabets);

        //Set a ClickListener on that View
        frenchAlphabets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiAlphabetsActivity}
                Intent fAlphabets = new Intent(FrenchActivity.this, GujaratiAlphabetsActivity.class);

                //Start the new Activity;
                startActivity(fAlphabets);
            }
        });
        //Find View that shows Numbers Category
        TextView frenchNumbers = (TextView) findViewById(R.id.french_numbers);

        //Set a ClickListener on that View
        frenchNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiNumbersActivity}
                Intent fNumbers = new Intent(FrenchActivity.this, GujaratiNumbersActivity.class);

                //Start the new Activity;
                startActivity(fNumbers);
            }
        });

        //Find View that shows Colors Category
        TextView frenchColors = (TextView) findViewById(R.id.french_colors);

        //Set a ClickListener on that View
        frenchColors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiColorsActivity}
                Intent fColors = new Intent(FrenchActivity.this, GujaratiColorsActivity.class);

                //Start the new Activity;
                startActivity(fColors);
            }
        });

        //Find View that shows Phrases Category
        TextView frenchPhrases = (TextView) findViewById(R.id.french_phrases);

        //Set a ClickListener on that View
        frenchPhrases.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link GujaratiPhrasesActivity}
                Intent fPhrases = new Intent(FrenchActivity.this, GujaratiPhrasesActivity.class);

                //Start the new Activity;
                startActivity(fPhrases);
            }
        });

    }


}
