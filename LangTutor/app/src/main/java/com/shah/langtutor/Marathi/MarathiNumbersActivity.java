package com.shah.langtutor.Marathi;

import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MarathiNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Creating an ArrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One","Ēka"));
        words.add(new Word("Two","Dōna"));
        words.add(new Word("Three","Tīna"));
        words.add(new Word("Four","Cāra"));
        words.add(new Word("Five","Pāca"));
        words.add(new Word("Six","Sahā"));
        words.add(new Word("Seven","Sāta"));
        words.add(new Word("Eight","Āṭha"));
        words.add(new Word("Nine","Na'ū"));
        words.add(new Word("Ten","Dahā"));

        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
