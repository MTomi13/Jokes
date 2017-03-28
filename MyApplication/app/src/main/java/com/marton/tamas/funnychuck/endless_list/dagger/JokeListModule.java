package com.marton.tamas.funnychuck.endless_list.dagger;

import com.marton.tamas.funnychuck.endless_list.JokeListPresenterImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListView;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@Module
public class JokeListModule {

    private JokeListView jokeListView;

    public JokeListModule(JokeListView jokeListView) {
        this.jokeListView = jokeListView;
    }

    @Provides
    public JokeListView provideJokeListView() {
        return jokeListView;
    }

    @Provides
    public JokeListPresenterImpl provideJokeListPresenter(JokeListView jokeListView, JokeInteractorImpl jokeInteractor) {
        return new JokeListPresenterImpl(jokeInteractor, jokeListView);
    }
}