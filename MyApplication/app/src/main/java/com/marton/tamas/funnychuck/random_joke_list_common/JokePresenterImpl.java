package com.marton.tamas.funnychuck.random_joke_list_common;

/**
 * Created by tamas.marton on 23/03/2017.
 */
//common presenter class with JokeDialog and JokeListPresenterImpl
public class JokePresenterImpl implements JokePresenter {

    private final JokeInteractorImpl jokeInteractor;

    public JokePresenterImpl(JokeInteractorImpl jokeInteractor) {
        this.jokeInteractor = jokeInteractor;
    }

    /**
     * @param isFilterNeeded boolean
     * @param numberOfJokes int
     *                      method to start fetch jokes and decide filtering is need or not
     */
    @Override
    public void getJokes(boolean isFilterNeeded, int numberOfJokes) {
        if (isFilterNeeded) {
            jokeInteractor.getFilteredJokesFromApi(numberOfJokes);
        } else {
            jokeInteractor.getJokesFromApi(numberOfJokes);
        }
    }
}