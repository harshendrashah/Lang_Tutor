package com.shah.langtutor;

/**
 * {@link Word} represents a vocabulary word that user wants to learn
 * It contains a default translation and specific language translation of that word.
 */

public class Word {

    //Default Translation of the word
    private String mDefaultTranslation;

    //Specific Language Script of the word
    private String mLanguageScript;

    //Specific Language Translation of the word
    private String mLanguageTranslation;

    //Specific Image Resource for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static int NO_IMAGE_PROVIDED = -1;

    //Specific Audio Resource for the word
    private int mAudioResourceId;

    //Constructor for Phrases Activity
    public Word(String languageScript, String languageTranslation,String defaultTranslation, int audioResourceId){
        mLanguageScript = languageScript;
        mLanguageTranslation = languageTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    //Constructor for Alphabets, Numbers and Colors Activity
    public Word(String languageScript, String languageTranslation,String defaultTranslation, int imageResourceId, int audioResourceId){
        mLanguageScript = languageScript;
        mLanguageTranslation = languageTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
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
     * Get the Language Script of the word
     * @return
     */
    public String getLanguageScript(){
        return  mLanguageScript;
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

}
