package com.shah.langtutor.Marathi;

import com.shah.langtutor.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MarathiPhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MarathiPhrasesFragment())
                .commit();
    }
}
