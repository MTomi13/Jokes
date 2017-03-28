package com.marton.tamas.funnychuck.endless_list;

import android.support.v4.app.Fragment;

import com.marton.tamas.funnychuck.BaseFragmentActivity;

/**
 * Created by tamas.marton on 27/03/2017.
 */

public class JokeListActivity extends BaseFragmentActivity {


    @Override
    protected String getTag() {
        return JokeListFragment.class.getSimpleName();
    }

    @Override
    protected Fragment getFragment() {
        return JokeListFragment.getInstance(isFilterNeed);
    }
}