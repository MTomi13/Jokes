package com.marton.tamas.funnychuck.home;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.marton.tamas.funnychuck.JokeApplication;
import com.marton.tamas.funnychuck.dependencies.ActivityModule;

import butterknife.ButterKnife;
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

        activityGraph = ((JokeApplication) getApplicationContext()).getApplicationGraph().plus(new ActivityModule(this));
        inject(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    private void inject(Object object) {
        activityGraph.inject(object);
    }

    @Override
    protected void onDestroy() {
        activityGraph = null;
        super.onDestroy();
    }
}