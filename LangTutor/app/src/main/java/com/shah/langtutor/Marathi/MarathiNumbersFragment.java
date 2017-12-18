package com.shah.langtutor.Marathi;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.shah.langtutor.R;
import com.shah.langtutor.Word;
import com.shah.langtutor.WordAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarathiNumbersFragment extends Fragment {

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


    public MarathiNumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.words_list, container,false);

        //Create and set uo {@link AudioManager} to request Audio Focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter adapter = new WordAdapter(getActivity(),words,R.color.category_numbers);

        ListView listView = (ListView)rootView.findViewById(R.id.list);

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
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    //Start the audio file
                    mMediaPlayer.start();
                    //Set up a listener on the Mediaplayer so that we can stop an release the resources
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
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
