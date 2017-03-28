package com.marton.tamas.funnychuck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.marton.tamas.funnychuck.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tamas.marton on 27/03/2017.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    protected boolean isFilterNeed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        isFilterNeed = getIntent().getBooleanExtra(Constants.FILTER_FLAG, false);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragment = supportFragmentManager.findFragmentByTag(getTag());
        if (fragment == null) {
            setupFragment(supportFragmentManager);
        }
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupFragment(FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, 0, android.R.anim.slide_out_right);
        transaction.add(R.id.container, getFragment(), getTag());
        transaction.commit();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract String getTag();

    protected abstract Fragment getFragment();
}