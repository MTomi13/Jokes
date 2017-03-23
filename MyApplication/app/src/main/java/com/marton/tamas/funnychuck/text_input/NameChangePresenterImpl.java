package com.marton.tamas.funnychuck.text_input;

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

    /**
     * @param isFilterNeeded boolean
     * @param fullName       String
     *                       method to start data fetching and decide need filtering or not
     */
    @Override
    public void getJokesWithChangedName(boolean isFilterNeeded, String fullName) {
        if (!fullName.equals(Constants.EMPTY_STRING)) {
            Name name = getName(fullName);
            if (name != null) {
                nameChangeView.showProgressRing(View.VISIBLE);
                if (isFilterNeeded) {
                    nameChangeInteractor.getJokeWithChangedNameAndFilter(name);
                } else {
                    nameChangeInteractor.getJokeWithChangedName(name);
                }
            }
        }
    }

    /**
     * @param fullName String
     * @return Name
     * split string with the first space, to create Name object
     */
    private Name getName(String fullName) {
        String[] splitedName = fullName.split("\\s+");
        if (splitedName.length != 2) {
            nameChangeView.showError("Pls use just one Firstname, and Lastname to change the character name!");
            return null;
        } else {
            return new Name(splitedName[0], splitedName[1]);
        }
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