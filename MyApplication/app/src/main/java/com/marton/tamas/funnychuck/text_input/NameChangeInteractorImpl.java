package com.marton.tamas.funnychuck.text_input;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.api.model.Name;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class NameChangeInteractorImpl implements NameChangeInteractor, Callback<JokeResponse> {

    private JokeFetchListener jokeFetchListener;
    private JokeRequester jokeRequester;

    public NameChangeInteractorImpl(JokeRequester jokeRequester) {
        this.jokeRequester = jokeRequester;
    }

    @Override
    public void getJokeWithChangedName(Name name) {
        jokeRequester.changeNameOfCharacter(this, name);
    }

    @Override
    public void getJokeWithChangedNameAndFilter(Name name) {
        ArrayList<String> categories = new ArrayList<>();
        categories.add(Constants.CATEGORY_EXPLICIT);
        jokeRequester.changeNameOfCharacterWithFilter(this, name, categories);
    }

    @Override
    public void setJokeFetchListener(JokeFetchListener jokeFetchListener) {
        this.jokeFetchListener = jokeFetchListener;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
        jokeFetchListener.onFetchJokesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<JokeResponse> call, Throwable t) {
        jokeFetchListener.onFetchJokesFailed(t.getLocalizedMessage());
    }
}