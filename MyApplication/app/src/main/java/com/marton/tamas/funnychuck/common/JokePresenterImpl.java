package com.marton.tamas.funnychuck.common;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokePresenterImpl implements JokePresenter {

    private final JokeInteractorImpl jokeInteractor;
    protected final JokeView jokeView;

    public JokePresenterImpl(JokeInteractorImpl jokeInteractor, JokeView jokeView) {
        this.jokeInteractor = jokeInteractor;
        this.jokeView = jokeView;
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