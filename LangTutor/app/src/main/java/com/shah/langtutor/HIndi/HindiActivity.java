package com.shah.langtutor.HIndi;

import com.shah.langtutor.Gujarati.GujaratiCategoryAdapter;
import com.shah.langtutor.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HindiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.hindi_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        HindiCategoryAdapter adapter = new HindiCategoryAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

}
