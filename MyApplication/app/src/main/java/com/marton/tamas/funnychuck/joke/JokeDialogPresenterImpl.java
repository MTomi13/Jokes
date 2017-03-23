package com.marton.tamas.funnychuck.joke;

import android.view.View;

import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.common.JokePresenterImpl;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokeDialogPresenterImpl extends JokePresenterImpl implements JokeInteractorImpl.JokeInteractorListener {

    private final JokeDialogView jokeDialogView;

    public JokeDialogPresenterImpl(JokeInteractorImpl jokeInteractor, JokeDialogView jokeDialogView) {
        super(jokeInteractor, jokeDialogView);
        this.jokeDialogView = jokeDialogView;
        jokeInteractor.setJokeInteractorListener(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onFetchJokesSuccess(JokeResponse jokeResponse) {
        jokeDialogView.showProgressRing(View.GONE);
        jokeDialogView.showJokes(jokeResponse.getJokeList());
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        jokeDialogView.showProgressRing(View.GONE);
        jokeDialogView.showError(errorMessage);
    }
}