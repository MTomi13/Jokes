package com.marton.tamas.funnychuck.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.marton.tamas.funnychuck.JokeApplication;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.dependencies.ActivityModule;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import dagger.ObjectGraph;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class HomeActivity extends AppCompatActivity {

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

        activityGraph = ((JokeApplication) getApplicationContext()).getApplicationGraph().plus(new ActivityModule(this));
        inject(this);
    }

    private void inject(Object object) {
        activityGraph.inject(object);
    }

    @OnClick(R.id.btn_random_joke)
    private void onRandomJokeBtnClicked() {

    }

    @OnClick(R.id.btn_text_input)
    private void onTextInputBtnClicked() {

    }

    @OnClick(R.id.btn_lazy_list)
    private void onEndlessListBtnClicked() {

    }

    @OnCheckedChanged(R.id.deny_explicit)
    private void onFilterChecked() {

    }

    @Override
    protected void onDestroy() {
        activityGraph = null;
        super.onDestroy();
    }
}