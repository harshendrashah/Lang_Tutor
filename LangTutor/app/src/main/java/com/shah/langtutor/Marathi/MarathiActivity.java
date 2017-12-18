package com.shah.langtutor.Marathi;

import com.shah.langtutor.HIndi.HindiCategoryAdapter;
import com.shah.langtutor.R;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
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

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.marathi_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        MarathiCategoryAdapter adapter = new MarathiCategoryAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

}
