package com.marton.tamas.funnychuck.random_joke_list_common;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeInteractorImpl implements JokeInteractor, Callback<JokeResponse> {

    private JokeRequester jokeRequester;
    private JokeFetchListener jokeFetchListener;

    public JokeInteractorImpl(JokeRequester jokeRequester) {
        this.jokeRequester = jokeRequester;
    }

    @Override
    public void getJokesFromApi(int numberOfJokes) {
        jokeRequester.getRandomJokes(this, numberOfJokes);
    }

    @Override
    public void getFilteredJokesFromApi(int numberOfJokes) {
        ArrayList<String> categories = new ArrayList<>();
        categories.add(Constants.CATEGORY_EXPLICIT);
        jokeRequester.getJokesExcludeCategory(this, numberOfJokes, categories);
    }

    @Override
    public void setJokeFetchListener(JokeFetchListener jokeFetchListener) {
        this.jokeFetchListener = jokeFetchListener;
    }

    @Override
    public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
        jokeFetchListener.onFetchJokesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<JokeResponse> call, Throwable throwable) {
        jokeFetchListener.onFetchJokesFailed(throwable.getLocalizedMessage());
    }
}