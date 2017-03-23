package com.marton.tamas.funnychuck.text_input;

import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.api.model.Name;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.common.BaseJokeView;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangePresenterImpl implements NameChangePresenter, JokeFetchListener {

    private NameChangeInteractorImpl nameChangeInteractor;
    private BaseJokeView baseJokeView;

    public NameChangePresenterImpl(NameChangeInteractorImpl nameChangeInteractor, BaseJokeView baseJokeView) {
        this.nameChangeInteractor = nameChangeInteractor;
        this.baseJokeView = baseJokeView;
    }

    @Override
    public void getJokesWithChangedName(boolean isFilterNeeded, String firstName, String lastName) {
        Name name = new Name(firstName, lastName);
        if (isFilterNeeded) {
            nameChangeInteractor.getJokeWithChangedName(name);
        } else {
            nameChangeInteractor.getJokeWithChangedNameAndFilter(name);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onFetchJokesSuccess(JokeResponse jokeResponse) {
        baseJokeView.showJokes(jokeResponse.getJokeList());
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        baseJokeView.showError(errorMessage);
    }
}