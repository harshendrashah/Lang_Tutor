package com.shah.langtutor.Gujarati;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by lenovo on 18-12-2017.
 */

public class GujaratiCategoryAdapter extends FragmentPagerAdapter {

    /**
     * Create a new {@link GujaratiCategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public GujaratiCategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GujaratiAlphabetsFragment();
        } else if (position == 1) {
            return new GujaratiNumbersFragment();
        } else if (position == 2) {
            return new GujaratiColorsFragment();
        } else {
            return new GujaratiPhrasesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
