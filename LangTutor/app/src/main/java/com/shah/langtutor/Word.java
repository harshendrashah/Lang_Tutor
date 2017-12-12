package com.shah.langtutor;

/**
 * {@link Word} represents a vocabulary word that user wants to learn
 * It contains a default translation and specific language translation of that word.
 */

public class Word {

    //Default Translation of the word
    private String mDefaultTranslation;

    //Specific Language Translation of the word
    private String mLanguageTranslation;

    //Constructor
    public Word(String defaultTranslation, String languageTranslation){
        mDefaultTranslation = defaultTranslation;
        mLanguageTranslation = languageTranslation;
    }

    /**
     * Get the Default Translation of the word
     * @return
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get Specific Language Translation of the word
     * @return
     */
    public String getLanguageTranslation(){
        return mLanguageTranslation;
    }
}
