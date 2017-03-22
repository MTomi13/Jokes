package com.marton.tamas.funnychuck.endless_list;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.model.JokeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListInteractorImpl implements JokeListInteractor, Callback<JokeResponse> {

    private JokeRequester jokeRequester;
    private JokeListInteractorListener jokeListInteractorListener;

    public JokeListInteractorImpl(JokeRequester jokeRequester) {
        this.jokeRequester = jokeRequester;
    }

    @Override
    public void getJokesFromApi() {
        jokeRequester.getRandomJokes(this);
    }

    @Override
    public void getFilteredJokesFromApi() {
        jokeRequester.getRandomJokes(this);
    }

    @Override
    public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
        jokeListInteractorListener.onFetchJokesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<JokeResponse> call, Throwable throwable) {
        jokeListInteractorListener.onFetchJokesFailed(throwable.getLocalizedMessage());
    }

    @Override
    public void setJokeListInteractorListener(JokeListInteractorListener jokeListInteractorListener) {
        this.jokeListInteractorListener = jokeListInteractorListener;
    }

    interface JokeListInteractorListener {

        void onFetchJokesSuccess(JokeResponse jokeResponse);

        void onFetchJokesFailed(String errorMessage);
    }
}