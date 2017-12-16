package com.shah.langtutor.Marathi;

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

public class MarathiNumbersActivity extends AppCompatActivity {

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

        words.add(new Word(R.string.marathi_number_one_script,R.string.marathi_number_one,
                R.string.english_number_one,R.drawable.number_one));
        words.add(new Word(R.string.marathi_number_two_script,R.string.marathi_number_two,
                R.string.english_number_two,R.drawable.number_two));
        words.add(new Word(R.string.marathi_number_three_script,R.string.marathi_number_three,
                R.string.english_number_three,R.drawable.number_three));
        words.add(new Word(R.string.marathi_number_four_script,R.string.marathi_number_four,
                R.string.english_number_four,R.drawable.number_four));
        words.add(new Word(R.string.marathi_number_five_script,R.string.marathi_number_five,
                R.string.english_number_five,R.drawable.number_five));
        words.add(new Word(R.string.marathi_number_six_script,R.string.marathi_number_six,
                R.string.english_number_six,R.drawable.number_six));
        words.add(new Word(R.string.marathi_number_seven_script,R.string.marathi_number_seven,
                R.string.english_number_seven,R.drawable.number_seven));
        words.add(new Word(R.string.marathi_number_eight_script,R.string.marathi_number_eight,
                R.string.english_number_eight,R.drawable.number_eight));
        words.add(new Word(R.string.marathi_number_nine_script,R.string.marathi_number_nine,
                R.string.english_number_nine,R.drawable.number_nine));
        words.add(new Word(R.string.marathi_number_two_script,R.string.marathi_number_ten,
                R.string.english_number_ten,R.drawable.number_ten));

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
                    mMediaPlayer = MediaPlayer.create(MarathiNumbersActivity.this, word.getAudioResourceId());
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
