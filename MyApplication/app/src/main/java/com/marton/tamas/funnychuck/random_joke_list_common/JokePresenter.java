package com.marton.tamas.funnychuck.random_joke_list_common;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokePresenter {

    void getJokes(boolean isFilterNeeded, int numberOfJokes);
}