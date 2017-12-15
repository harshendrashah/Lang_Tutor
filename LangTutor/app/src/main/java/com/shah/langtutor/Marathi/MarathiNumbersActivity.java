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

        words.add(new Word("एक","Ēka","One",R.drawable.number_one));
        words.add(new Word("दोन","Dōna","Two",R.drawable.number_two));
        words.add(new Word("तीन","Tīna","Three",R.drawable.number_three));
        words.add(new Word("चार","Cāra","Four",R.drawable.number_four));
        words.add(new Word("पाच","Pāca","Five",R.drawable.number_five));
        words.add(new Word("सहा","Sahā","Six",R.drawable.number_six));
        words.add(new Word("सात","Sāta","Seven",R.drawable.number_seven));
        words.add(new Word("आठ","Āṭha","Eight",R.drawable.number_eight));
        words.add(new Word("नऊ","Na'ū","Nine",R.drawable.number_nine));
        words.add(new Word("दहा","Dahā","Ten",R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
