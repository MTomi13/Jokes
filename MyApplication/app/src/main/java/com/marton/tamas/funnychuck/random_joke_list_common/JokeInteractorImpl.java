package com.marton.tamas.funnychuck.random_joke_list_common;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.model.JokeListResponse;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeInteractorImpl implements JokeInteractor, Callback<JokeListResponse> {

    private JokeRequester jokeRequester;
    private JokeFetchListener jokeFetchListener;

    public JokeInteractorImpl(JokeRequester jokeRequester) {
        this.jokeRequester = jokeRequester;
    }

    /**
     * @param numberOfJokes int
     *                      get jokes form api without filtering
     */
    @Override
    public void getJokesFromApi(int numberOfJokes) {
        jokeRequester.getRandomJokes(this, numberOfJokes);
    }

    /**
     * @param numberOfJokes int
     *                      get jokes from api with filtering
     */
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

    @SuppressWarnings("unchecked")
    @Override
    public void onResponse(Call<JokeListResponse> call, Response<JokeListResponse> response) {
        jokeFetchListener.onFetchJokesSuccess(response.body());
    }

    @Override
    public void onFailure(Call<JokeListResponse> call, Throwable throwable) {
        jokeFetchListener.onFetchJokesFailed(throwable.getLocalizedMessage());
    }
}