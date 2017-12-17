package com.shah.langtutor;

/**
 * {@link Word} represents a vocabulary word that user wants to learn
 * It contains a default translation and specific language translation of that word.
 */

public class Word {

    //Default Translation of the word
    private int mDefaultTranslation;

    //Specific Language Script of the word
    private int mLanguageScript;

    //Specific Language Translation of the word
    private int mLanguageTranslation;

    //Specific Image Resource for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static int NO_IMAGE_PROVIDED = -1;

    //Specific Audio Resource for the word
    private int mAudioResourceId;

    //Checks the activity is phrases activity or not
    private boolean mHasPhrases;

    //Constructor for Phrases Activity
    public Word(int languageScript, int languageTranslation,int defaultTranslation, int audioResourceId){
        mLanguageScript = languageScript;
        mLanguageTranslation = languageTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    //Constructor for Alphabets, Numbers and Colors Activity
    public Word(int languageScript, int languageTranslation,int defaultTranslation, int imageResourceId, int audioResourceId){
        mLanguageScript = languageScript;
        mLanguageTranslation = languageTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //Constructor or phrases activity
    public Word(int languageScript, int languageTranslation,int defaultTranslation, int audioResourceId,boolean HasPhrases){
        mLanguageScript = languageScript;
        mLanguageTranslation = languageTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
        mHasPhrases = HasPhrases;
    }

    /**
     * Get the Language Script of the word
     * @return
     */
    public int getLanguageScript(){
        return  mLanguageScript;
    }

    /**
     * Get the Default Translation of the word
     * @return
     */
    public int getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get Specific Language Translation of the word
     * @return
     */
    public int getLanguageTranslation(){
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

    /**
     * Get the Audio Resource for the word
     * @return
     */
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    /**
     * returns whether Activity is phrases or not
     * @return
     */
    public boolean getHasPhrases(){
        return mHasPhrases;
    }

}
