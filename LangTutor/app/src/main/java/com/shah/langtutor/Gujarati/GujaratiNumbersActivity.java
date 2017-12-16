package com.shah.langtutor.Gujarati;

import com.shah.langtutor.HIndi.HindiNumbersActivity;
import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class GujaratiNumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    //Handles Audio Focus while playing a sound file
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        mMediaPlayer.start();
                    }
                    else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        releaseMediaPlayer();
                    }
                }
            };

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

        //Create and set uo {@link AudioManager} to request Audio Focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //Creating an ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

<<<<<<< HEAD
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
=======
        words.add(new Word("એક","Ēka","One",R.drawable.number_one,R.raw.gujarati_number_one));
        words.add(new Word("બે","Bē","Two",R.drawable.number_two,R.raw.gujarati_number_two));
        words.add(new Word("ત્રણ","Traṇa","Three",R.drawable.number_three,R.raw.gujarati_number_three));
        words.add(new Word("ચાર","Cāra","Four",R.drawable.number_four,R.raw.gujarati_number_four));
        words.add(new Word("પાંચ","Pān̄ca","Five",R.drawable.number_five,R.raw.gujarati_number_five));
        words.add(new Word("છ","Cha","Six",R.drawable.number_six,R.raw.gujarati_number_six));
        words.add(new Word("સાત","Sāta","Seven",R.drawable.number_seven,R.raw.gujarati_number_seven));
        words.add(new Word("આઠ","Āṭha","Eight",R.drawable.number_eight,R.raw.gujarati_number_eight));
        words.add(new Word("નવ","Nava","Nine",R.drawable.number_nine,R.raw.gujarati_number_nine));
        words.add(new Word("દસ","Dasa","Ten",R.drawable.number_ten,R.raw.gujarati_number_ten));
>>>>>>> 46efc97d0e5aa64bda6ec4b2d82ef8690733cfd2


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

                //Request Audio Focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //Use the music stream
                        AudioManager.STREAM_MUSIC,
                        //Request Permanent Focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //Create and set up {@link MediaPlayer} for the audio resource associated with the current word
                    mMediaPlayer = MediaPlayer.create(GujaratiNumbersActivity.this, word.getAudioResourceId());
                    //Start the audio file
                    mMediaPlayer.start();
                    //Set up a listener on the Mediaplayer so that we can stop an release the resources
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
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
            //Abandon audio Focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
