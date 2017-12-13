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

        words.add(new Word("One","Ēka",R.drawable.number_one));
        words.add(new Word("Two","Bē",R.drawable.number_two));
        words.add(new Word("Three","Traṇa",R.drawable.number_three));
        words.add(new Word("Four","Cāra",R.drawable.number_four));
        words.add(new Word("Five","Pān̄ca",R.drawable.number_five));
        words.add(new Word("Six","Cha",R.drawable.number_six));
        words.add(new Word("Seven","Sāta",R.drawable.number_seven));
        words.add(new Word("Eight","Āṭha",R.drawable.number_eight));
        words.add(new Word("Nine","Nava",R.drawable.number_nine));
        words.add(new Word("Ten","Dasa",R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
