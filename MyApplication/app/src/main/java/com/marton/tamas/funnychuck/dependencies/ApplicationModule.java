package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.JokeApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */

@Module
class ApplicationModule {

    private JokeApplication jokeApplication;

    public ApplicationModule(JokeApplication jokeApplication) {
        this.jokeApplication = jokeApplication;
    }

    @Provides
    JokeApplication provideApplication() {
        return jokeApplication;
    }
}