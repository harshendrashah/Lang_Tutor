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
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("એક","Ēka","One",R.drawable.number_one));
        words.add(new Word("બે","Bē","Two",R.drawable.number_two));
        words.add(new Word("ત્રણ","Traṇa","Three",R.drawable.number_three));
        words.add(new Word("ચાર","Cāra","Four",R.drawable.number_four));
        words.add(new Word("પાંચ","Pān̄ca","Five",R.drawable.number_five));
        words.add(new Word("છ","Cha","Six",R.drawable.number_six));
        words.add(new Word("સાત","Sāta","Seven",R.drawable.number_seven));
        words.add(new Word("આઠ","Āṭha","Eight",R.drawable.number_eight));
        words.add(new Word("નવ","Nava","Nine",R.drawable.number_nine));
        words.add(new Word("દસ","Dasa","Ten",R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
