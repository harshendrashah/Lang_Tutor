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

    //Specific Image Resource for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static int NO_IMAGE_PROVIDED = -1;

    //Constructor for Phrases Activity
    public Word(String defaultTranslation, String languageTranslation){
        mDefaultTranslation = defaultTranslation;
        mLanguageTranslation = languageTranslation;
    }

    //Constructor for Alphabets, Numbers and Colors Activity
    public Word(String defaultTranslation, String languageTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mLanguageTranslation = languageTranslation;
        mImageResourceId = imageResourceId;
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

    /**
     * Get the Image Resource for the word
     * @return
     */
    public int getImageResourseID() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word
     * @return
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
