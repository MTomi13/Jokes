package com.marton.tamas.funnychuck.random_joke_list_common;

import com.marton.tamas.funnychuck.common.BaseJokeView;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokePresenterImpl implements JokePresenter {

    private final JokeInteractorImpl jokeInteractor;
    protected final BaseJokeView baseJokeView;

    public JokePresenterImpl(JokeInteractorImpl jokeInteractor, BaseJokeView baseJokeView) {
        this.jokeInteractor = jokeInteractor;
        this.baseJokeView = baseJokeView;
    }

    @Override
    public void getJokes(boolean isFilterNeeded, int numberOfJokes) {
        if (isFilterNeeded) {
            jokeInteractor.getFilteredJokesFromApi(numberOfJokes);
        } else {
            jokeInteractor.getJokesFromApi(numberOfJokes);
        }
    }
}