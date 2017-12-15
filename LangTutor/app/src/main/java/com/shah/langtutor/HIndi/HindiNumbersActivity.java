package com.shah.langtutor.HIndi;

import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HindiNumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    //For checking whether the audio is done playing or not
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Creating an ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("एक","Ek","One",R.drawable.number_one,R.raw.aal_izz_well));
        words.add(new Word("दो","Do","Two",R.drawable.number_two,R.raw.behti_hawa_sa));
        words.add(new Word("तीन","Teen","Three",R.drawable.number_three,R.raw.give_me_some_sunshine));
        words.add(new Word("चार","Chaar","Four",R.drawable.number_four,R.raw.zoobi_doobi_remix));
        words.add(new Word("पंज","Panj","Five",R.drawable.number_five,R.raw.aal_izz_well));
        words.add(new Word("छह","Chhah","Six",R.drawable.number_six,R.raw.zoobi_doobi_remix));
        words.add(new Word("सात","Saat","Seven",R.drawable.number_seven,R.raw.give_me_some_sunshine));
        words.add(new Word("आठ","Aath","Eight",R.drawable.number_eight,R.raw.behti_hawa_sa));
        words.add(new Word("नौ","Nau","Nine",R.drawable.number_nine,R.raw.aal_izz_well));
        words.add(new Word("दस","Das","Ten",R.drawable.number_ten,R.raw.give_me_some_sunshine));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Get the {@link Word} object at the given position user clicked on
                Word word = words.get(position);

                //Release the MediaPlayer if exists because we are about to play a new sound
                releaseMediaPlayer();

                //Create and set up {@link MediaPlayer} for the audio resource associated with the current word
                mMediaPlayer = MediaPlayer.create(HindiNumbersActivity.this,word.getAudioResourceId());
                //Start the audio file
                mMediaPlayer.start();
                //Set up a listener on the Mediaplayer so that we can stop an release the resources
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //When activity is stopped, release the MediaPlayer resources because we won't be playing any more sounds
        releaseMediaPlayer();
    }

    /**
     * Clean up MediaPlayer by releasing its resources
     */
    private void releaseMediaPlayer(){

        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
