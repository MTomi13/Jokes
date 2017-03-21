package com.marton.tamas.funnychuck;

import android.app.Application;

import com.marton.tamas.funnychuck.dependencies.ApplicationModule;
import com.marton.tamas.funnychuck.dependencies.NetworkModule;

import dagger.ObjectGraph;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        setupObjectGraph();
    }

    /**
     * setup objectGraph for dependency handling
     */
    private void setupObjectGraph() {
        objectGraph = ObjectGraph.create(new ApplicationModule(this), new NetworkModule());
    }

    public ObjectGraph getApplicationGraph() {
        return objectGraph;
    }
}