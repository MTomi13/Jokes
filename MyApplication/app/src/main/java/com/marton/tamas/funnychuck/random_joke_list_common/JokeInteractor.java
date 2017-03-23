package com.marton.tamas.funnychuck.random_joke_list_common;

import com.marton.tamas.funnychuck.common.BaseJokeInteractor;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeInteractor extends BaseJokeInteractor {

    void getJokesFromApi(int numberOfJokes);

    void getFilteredJokesFromApi(int numberOfJokes);
}