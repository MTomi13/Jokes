package com.marton.tamas.funnychuck.common;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.model.JokeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeInteractorImpl implements JokeInteractor, Callback<JokeResponse> {

    private JokeRequester jokeRequester;
    private JokeInteractorListener jokeInteractorListener;

    public JokeInteractorImpl(JokeRequester jokeRequester) {
        this.jokeRequester = jokeRequester;
    }

    @Override
    public void getJokesFromApi(int numberOfJokes) {
        jokeRequester.getRandomJokes(this, numberOfJokes);
    }

    @Override
    public void getFilteredJokesFromApi(int numberOfJokes) {
        jokeRequester.getRandomJokes(this, numberOfJokes);
    }

    @Override
    public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
        jokeInteractorListener.onFetchJokesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<JokeResponse> call, Throwable throwable) {
        jokeInteractorListener.onFetchJokesFailed(throwable.getLocalizedMessage());
    }

    public void setJokeInteractorListener(JokeInteractorListener jokeInteractorListener) {
        this.jokeInteractorListener = jokeInteractorListener;
    }

    public interface JokeInteractorListener {

        void onFetchJokesSuccess(JokeResponse jokeResponse);

        void onFetchJokesFailed(String errorMessage);
    }
}