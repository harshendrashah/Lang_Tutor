package com.shah.langtutor.French;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shah.langtutor.Marathi.MarathiCategoryAdapter;
import com.shah.langtutor.R;

public class FrenchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.french_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        FrenchCategoryAdapter adapter = new FrenchCategoryAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }


}
