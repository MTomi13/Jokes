package com.marton.tamas.funnychuck.common;

import com.marton.tamas.funnychuck.api.model.JokeListResponse;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokeFetchListener<T> {

    void onFetchJokesSuccess(T t);

    void onFetchJokesFailed(String errorMessage);
}