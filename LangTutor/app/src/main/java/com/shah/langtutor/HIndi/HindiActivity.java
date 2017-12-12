package com.shah.langtutor.HIndi;

import com.shah.langtutor.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HindiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);

        //Find View that shows Alphabets Category
        TextView hindiAlphabets = (TextView) findViewById(R.id.hindi_alphabates);

        //Set a ClickListener on that View
        hindiAlphabets.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link HindiAlphabetsActivity}
                Intent hAlphabets = new Intent(HindiActivity.this, HindiAlphabetsActivity.class);

                //Start the new Activity;
                startActivity(hAlphabets);
            }
        });
        //Find View that shows Numbers Category
        TextView hindiNumbers = (TextView) findViewById(R.id.hindi_numbers);

        //Set a ClickListener on that View
        hindiNumbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link HindiNumbersActivity}
                Intent hNumbers = new Intent(HindiActivity.this, HindiNumbersActivity.class);

                //Start the new Activity;
                startActivity(hNumbers);
            }
        });

        //Find View that shows Colors Category
        TextView hindiColors = (TextView) findViewById(R.id.hindi_colors);

        //Set a ClickListener on that View
        hindiColors.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link HindiColorsActivity}
                Intent hColors = new Intent(HindiActivity.this, HindiColorsActivity.class);

                //Start the new Activity;
                startActivity(hColors);
            }
        });

        //Find View that shows Phrases Category
        TextView hindiPhrases = (TextView) findViewById(R.id.hindi_phrases);

        //Set a ClickListener on that View
        hindiPhrases.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                //Creates new Intent to open {@link HindiPhrasesActivity}
                Intent hPhrases = new Intent(HindiActivity.this, HindiPhrasesActivity.class);

                //Start the new Activity;
                startActivity(hPhrases);
            }
        });

    }
}
