package com.marton.tamas.funnychuck.api;

import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.api.model.Name;

import java.util.ArrayList;

import retrofit2.Callback;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeRequester {

    private JokeService jokeService;

    public JokeRequester(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    public void getRandomJokes(Callback<JokeResponse> callback, int numberOfJokes) {
        jokeService.getRandomJokes(String.valueOf(numberOfJokes)).enqueue(callback);
    }

    public void changeNameOfCharacter(Callback<JokeResponse> callback, Name name) {
        jokeService.changeNameOfCharacter(name.getFirstName(), name.getLastName()).enqueue(callback);
    }

    public void changeNameOfCharacterWithFilter(Callback<JokeResponse> callback, Name name, ArrayList<String> categories) {
        jokeService.changeNameOfCharacterWithFilter(name.getFirstName(), name.getLastName(), categories).enqueue(callback);
    }

    public void getJokesExcludeCategory(Callback<JokeResponse> callback, int numberOfJokes, ArrayList<String> categories) {
        jokeService.getJokesWithFilter(String.valueOf(numberOfJokes), categories).enqueue(callback);
    }
}