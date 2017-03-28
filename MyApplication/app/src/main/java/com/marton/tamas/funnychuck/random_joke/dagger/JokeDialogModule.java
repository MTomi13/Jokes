package com.marton.tamas.funnychuck.random_joke.dagger;

import com.marton.tamas.funnychuck.random_joke.JokeContentView;
import com.marton.tamas.funnychuck.random_joke.JokeDialogPresenterImpl;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@Module
public class JokeDialogModule {

    private JokeContentView jokeContentView;

    public JokeDialogModule(JokeContentView jokeContentView) {
        this.jokeContentView = jokeContentView;
    }

    @Provides
    public JokeContentView provideJokeContentView() {
        return jokeContentView;
    }

    @Provides
    public JokeDialogPresenterImpl provideJokeDialogPresenterImpl(JokeInteractorImpl jokeInteractor, JokeContentView jokeContentView) {
        return new JokeDialogPresenterImpl(jokeInteractor, jokeContentView);
    }
}