package com.marton.tamas.funnychuck.common;

/**
 * Created by tamas.marton on 23/03/2017.
 */
//common generic interface to handle the server responses, and call back to the presenters
public interface JokeFetchListener<T> {

    void onFetchJokesSuccess(T response);

    void onFetchJokesFailed(String errorMessage);
}