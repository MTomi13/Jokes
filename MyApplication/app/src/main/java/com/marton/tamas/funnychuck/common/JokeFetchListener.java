package com.marton.tamas.funnychuck.common;

import com.marton.tamas.funnychuck.api.model.JokeResponse;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokeFetchListener {

    void onFetchJokesSuccess(JokeResponse jokeResponse);

    void onFetchJokesFailed(String errorMessage);
}