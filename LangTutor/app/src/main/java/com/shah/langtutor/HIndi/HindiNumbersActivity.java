package com.shah.langtutor.HIndi;

import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HindiNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Creating an ArrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One","Ek"));
        words.add(new Word("Two","Do"));
        words.add(new Word("Three","Teen"));
        words.add(new Word("Four","Chaar"));
        words.add(new Word("Five","Panj"));
        words.add(new Word("Six","Chhah"));
        words.add(new Word("Seven","Saat"));
        words.add(new Word("Eight","Aath"));
        words.add(new Word("Nine","Nau"));
        words.add(new Word("Ten","Das"));

        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
