package com.shah.langtutor.HIndi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shah.langtutor.R;


/**
 * Created by lenovo on 18-12-2017.
 */

public class HindiCategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;
    /**
     * Create a new {@link HindiCategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public HindiCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HindiAlphabetsFragment();
        } else if (position == 1) {
            return new HindiNumbersFragment();
        } else if (position == 2) {
            return new HindiColorsFragment();
        } else {
            return new HindiPhrasesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.alphabets);
        } else if (position == 1) {
            return mContext.getString(R.string.numbers);
        } else if (position == 2) {
            return mContext.getString(R.string.colors);
        } else {
            return mContext.getString(R.string.phrases);
        }
    }

}
