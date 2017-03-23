package com.marton.tamas.funnychuck.random_joke;

import android.view.View;

import com.marton.tamas.funnychuck.api.model.JokeListResponse;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.random_joke_list_common.JokePresenterImpl;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokeDialogPresenterImpl extends JokePresenterImpl implements JokeFetchListener<JokeListResponse> {

    private final JokeContentView jokeContentView;

    public JokeDialogPresenterImpl(JokeInteractorImpl jokeInteractor, JokeContentView jokeContentView) {
        super(jokeInteractor, jokeContentView);
        this.jokeContentView = jokeContentView;
        jokeInteractor.setJokeFetchListener(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onFetchJokesSuccess(JokeListResponse jokeListResponse) {
        jokeContentView.showProgressRing(View.GONE);
        jokeContentView.showJokes(jokeListResponse.getJokeList());
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        jokeContentView.showProgressRing(View.GONE);
        jokeContentView.showError(errorMessage);
    }
}