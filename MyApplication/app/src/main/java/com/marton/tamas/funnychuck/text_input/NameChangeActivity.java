package com.marton.tamas.funnychuck.text_input;

import android.support.v4.app.Fragment;

import com.marton.tamas.funnychuck.BaseFragmentActivity;

/**
 * Created by tamas.marton on 27/03/2017.
 */

public class NameChangeActivity extends BaseFragmentActivity {


    @Override
    protected String getTag() {
        return NameChangeFragment.class.getSimpleName();
    }

    @Override
    protected Fragment getFragment() {
        return NameChangeFragment.getInstance(isFilterNeed);
    }
}