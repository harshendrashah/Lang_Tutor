package com.shah.langtutor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 11-12-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    //Constructor
    public  WordAdapter(Activity context, ArrayList<Word> words){

        super(context,0,words);
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

        return  listItemView;

    }
}
