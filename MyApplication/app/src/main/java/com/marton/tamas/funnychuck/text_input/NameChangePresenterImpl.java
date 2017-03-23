package com.marton.tamas.funnychuck.text_input;

import android.support.annotation.NonNull;
import android.view.View;

import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.api.model.Name;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.util.Constants;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangePresenterImpl implements NameChangePresenter, JokeFetchListener<JokeResponse> {

    private NameChangeInteractorImpl nameChangeInteractor;
    private NameChangeView nameChangeView;

    public NameChangePresenterImpl(NameChangeInteractorImpl nameChangeInteractor, NameChangeView nameChangeView) {
        this.nameChangeInteractor = nameChangeInteractor;
        this.nameChangeView = nameChangeView;
        nameChangeInteractor.setJokeFetchListener(this);
    }

    @Override
    public void getJokesWithChangedName(boolean isFilterNeeded, String fullName) {
        if (!fullName.equals(Constants.EMPTY_STRING)) {
            nameChangeView.showProgressRing(View.VISIBLE);
            Name name = getName(fullName);
            if (isFilterNeeded) {
                nameChangeInteractor.getJokeWithChangedNameAndFilter(name);
            } else {
                nameChangeInteractor.getJokeWithChangedName(name);
            }
        }
    }

    @NonNull
    private Name getName(String fullName) {
        String[] splitedName = fullName.split("\\s+");
        return new Name(splitedName[0], splitedName[1]);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onFetchJokesSuccess(JokeResponse jokeResponse) {
        nameChangeView.showProgressRing(View.GONE);
        nameChangeView.showJoke(jokeResponse.getJoke());
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        nameChangeView.showProgressRing(View.GONE);
        nameChangeView.showError(errorMessage);
    }
}