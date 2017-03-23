package com.marton.tamas.funnychuck.common;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokeFetchListener<T> {

    void onFetchJokesSuccess(T t);

    void onFetchJokesFailed(String errorMessage);
}