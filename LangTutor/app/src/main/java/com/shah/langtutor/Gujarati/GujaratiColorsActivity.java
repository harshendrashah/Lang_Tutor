package com.shah.langtutor.Gujarati;

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

public class GujaratiColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    //Handles Audio Focus while playing a sound file
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
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

        words.add(new Word(R.string.gujarati_color_red_script, R.string.gujarati_color_red,
                R.string.english_color_red, R.drawable.color_red, R.raw.gujarati_color_red));
        words.add(new Word(R.string.gujarati_color_green_script, R.string.gujarati_color_green,
                R.string.english_color_green, R.drawable.color_green, R.raw.gujarati_color_green));
        words.add(new Word(R.string.gujarati_color_brown_script, R.string.gujarati_color_brown,
                R.string.english_color_brown, R.drawable.color_brown, R.raw.gujarati_color_brown));
        words.add(new Word(R.string.gujarati_color_gray_script, R.string.gujarati_color_gray,
                R.string.english_color_gray, R.drawable.color_gray, R.raw.gujarati_color_gray));
        words.add(new Word(R.string.gujarati_color_black_script, R.string.gujarati_color_black,
                R.string.english_color_black, R.drawable.color_black, R.raw.gujarati_color_black));
        words.add(new Word(R.string.gujarati_color_white_script, R.string.gujarati_color_white,
                R.string.english_color_white, R.drawable.color_white, R.raw.gujarati_color_white));
        words.add(new Word(R.string.gujarati_color_yellow_script, R.string.gujarati_color_yellow,
                R.string.english_color_yellow, R.drawable.color_mustard_yellow, R.raw.gujarati_color_yellow));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
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

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //Create and set up {@link MediaPlayer} for the audio resource associated with the current word
                    mMediaPlayer = MediaPlayer.create(GujaratiColorsActivity.this, word.getAudioResourceId());
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
    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            //Abandon audio Focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
