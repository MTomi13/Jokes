package com.marton.tamas.funnychuck.common;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeInteractor {

    void getJokesFromApi(int numberOfJokes);

    void getFilteredJokesFromApi(int numberOfJokes);

    void setJokeInteractorListener(JokeInteractorImpl.JokeInteractorListener jokeInteractorListener);
}