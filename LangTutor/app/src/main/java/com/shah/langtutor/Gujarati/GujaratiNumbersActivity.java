package com.shah.langtutor.Gujarati;

import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

public class GujaratiNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Creating an ArrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One","Ēka"));
        words.add(new Word("Two","Bē"));
        words.add(new Word("Three","Traṇa"));
        words.add(new Word("Four","Cāra"));
        words.add(new Word("Five","Pān̄ca"));
        words.add(new Word("Six","Cha"));
        words.add(new Word("Seven","Sāta"));
        words.add(new Word("Eight","Āṭha"));
        words.add(new Word("Nine","Nava"));
        words.add(new Word("Ten","Dasa"));


        WordAdapter adapter = new WordAdapter(this,words);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
