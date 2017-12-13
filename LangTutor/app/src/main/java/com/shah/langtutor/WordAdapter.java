package com.shah.langtutor;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 11-12-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

   // private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    //Resource ID for background color of this  list of words
    private int mColorResourceId;

    //Constructor
    public  WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){

        super(context,0,words);

        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item ,parent,false);
        }

        Word currentWord = getItem(position);

        TextView languageTextView = (TextView) listItemView.findViewById(R.id.language_text_view);
        languageTextView.setText(currentWord.getLanguageTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourseID());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color for the text_container view
        textContainer.setBackgroundColor(color);

        //Returns the whole list_item layout
        return  listItemView;
    }
}
