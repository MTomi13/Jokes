package com.marton.tamas.funnychuck.endless_list;

import com.marton.tamas.funnychuck.endless_list.JokeListInteractorImpl.JokeListInteractorListener;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeListInteractor {

    void getJokesFromApi();

    void getFilteredJokesFromApi();

    void setJokeListInteractorListener(JokeListInteractorListener jokeListInteractorListener);
}
