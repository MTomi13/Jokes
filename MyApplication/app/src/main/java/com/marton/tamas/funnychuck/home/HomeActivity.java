package com.marton.tamas.funnychuck.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.endless_list.JokeListFragment;
import com.marton.tamas.funnychuck.random_joke.JokeDialogFragment;
import com.marton.tamas.funnychuck.text_input.NameChangeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class HomeActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.uiMask)
    FrameLayout uiMask;

    private boolean isFilterNeed;

    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_home);

        setupFragmentManager();
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupFragmentManager() {
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.addOnBackStackChangedListener(this);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.btn_random_joke)
    public void onRandomJokeBtnClicked() {
        JokeDialogFragment jokeDialogFragment = JokeDialogFragment.getInstance(isFilterNeed);
        jokeDialogFragment.show(getSupportFragmentManager(), JokeDialogFragment.class.getSimpleName());
    }

    @OnClick(R.id.btn_text_input)
    public void onTextInputBtnClicked() {
        replaceFragment(NameChangeFragment.getInstance(isFilterNeed), NameChangeFragment.class.getSimpleName());
    }

    @OnClick(R.id.btn_lazy_list)
    public void onEndlessListBtnClicked() {
        replaceFragment(JokeListFragment.getInstance(isFilterNeed), JokeListFragment.class.getSimpleName());
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, 0, android.R.anim.slide_out_right);
        transaction.addToBackStack(tag);
        transaction.replace(R.id.container, fragment);
        transaction.commit();
        uiMask.setVisibility(View.VISIBLE);
    }

    @OnCheckedChanged(R.id.deny_explicit)
    public void onFilterChecked() {
        isFilterNeed = !isFilterNeed;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                handleBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        handleBackPressed();
    }

    /**
     * handle back button pressed, if there is a fragment is visible, pop out form backstack,
     * if there is no more fragment, finish the activity
     */
    private void handleBackPressed() {
        Fragment fragment = supportFragmentManager.findFragmentById(R.id.container);
        if (fragment != null) {
            supportFragmentManager.popBackStack();
            supportFragmentManager.executePendingTransactions();
            uiMask.setVisibility(View.GONE);
            toolbar.setTitle(R.string.app_name);
        } else {
            finish();
        }
    }

    /**
     * remove home arrow from the toolbar if there is no fragment in the backstack
     */
    @Override
    public void onBackStackChanged() {
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            setupHomeAsUpButton(true);
        } else {
            setupHomeAsUpButton(false);
        }
    }

    private void setupHomeAsUpButton(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enable); // show back button
        }
    }
}