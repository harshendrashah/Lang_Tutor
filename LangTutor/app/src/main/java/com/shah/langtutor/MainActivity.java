package com.shah.langtutor;

import com.shah.langtutor.French.FrenchActivity;
import com.shah.langtutor.Gujarati.GujaratiActivity;
import com.shah.langtutor.HIndi.HindiActivity;
import com.shah.langtutor.Marathi.MarathiActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find view that shows Hindi Category
        TextView hindi = (TextView) findViewById(R.id.hindi_text_view);

        //set a clickListener on that view
        hindi.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                //Creates new Intent to open {@link HindiActivity}
                Intent hindiIntent = new Intent(MainActivity.this, HindiActivity.class);

                //Start the new Activity
                startActivity(hindiIntent);

            }
        });

        //Find view that shows Gujarati Category
        TextView gujarati = (TextView) findViewById(R.id.gujarati_text_view);

        //set a clickListener on that view
        gujarati.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                //Creates new Intent to open {@link GujaratiActivity}
                Intent gujaratiIntent = new Intent(MainActivity.this, GujaratiActivity.class);

                //Start the new Activity
                startActivity(gujaratiIntent);

            }
        });

        //Find view that shows Marathi Category
        TextView marathi = (TextView) findViewById(R.id.marathi_text_view);

        //set a clickListener on that view
        marathi.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                //Creates new Intent to open {@link MarathiActivity}
                Intent marathiIntent = new Intent(MainActivity.this, MarathiActivity.class);

                //Start the new Activity
                startActivity(marathiIntent);

            }
        });

        //Find view that shows Hindi Category
        TextView french = (TextView) findViewById(R.id.french_text_view);

        //set a clickListener on that view
        french.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                //Creates new Intent to open {@link HindiActivity}
                Intent frenchIntent = new Intent(MainActivity.this, FrenchActivity.class);

                //Start the new Activity
                startActivity(frenchIntent);

            }
        });

    }

}
