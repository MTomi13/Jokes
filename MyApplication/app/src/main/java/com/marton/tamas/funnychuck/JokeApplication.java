package com.marton.tamas.funnychuck;

import android.app.Application;
import android.content.Context;

import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.dependencies.DaggerApplicationComponent;
import com.marton.tamas.funnychuck.dependencies.DomainModule;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerApplicationComponent.builder()
                .domainModule(new DomainModule(this))
                .build();
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

    public static JokeApplication get(Context context) {
        return (JokeApplication) context.getApplicationContext();
    }
}