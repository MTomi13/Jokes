package com.marton.tamas.funnychuck.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.endless_list.JokeListActivity;
import com.marton.tamas.funnychuck.random_joke.JokeDialogFragment;
import com.marton.tamas.funnychuck.text_input.NameChangeActivity;
import com.marton.tamas.funnychuck.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isFilterNeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.btn_random_joke)
    public void onRandomJokeBtnClicked() {
        JokeDialogFragment jokeDialogFragment = JokeDialogFragment.getInstance(false);
        jokeDialogFragment.show(getSupportFragmentManager(), JokeDialogFragment.class.getSimpleName());
    }

    @OnClick(R.id.btn_text_input)
    public void onTextInputBtnClicked() {
        Intent intent = new Intent(this, NameChangeActivity.class);
        intent.putExtra(Constants.FILTER_FLAG, isFilterNeed);
        startActivity(intent);
    }

    @OnClick(R.id.btn_lazy_list)
    public void onEndlessListBtnClicked() {
        Intent intent = new Intent(this, JokeListActivity.class);
        intent.putExtra(Constants.FILTER_FLAG, isFilterNeed);
        startActivity(intent);
    }

    @OnCheckedChanged(R.id.deny_explicit)
    public void onFilterChecked() {
        isFilterNeed = !isFilterNeed;
    }
}