package com.marton.tamas.funnychuck.api;

import com.marton.tamas.funnychuck.api.model.JokeListResponse;
import com.marton.tamas.funnychuck.api.model.JokeResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeService {

    @GET("random/" + "{number}")
    Call<JokeListResponse> getRandomJokes(
            @Path("number") String number);

    @GET("random")
    Call<JokeResponse> changeNameOfCharacter(
            @Query("firstName") String firstName,
            @Query("lastName") String lastName);

    @GET("random")
    Call<JokeResponse> changeNameOfCharacterWithFilter(
            @Query("firstName") String firstName,
            @Query("lastName") String lastName,
            @Query("exclude") ArrayList<String> category);

    @GET("random/" + "{number}")
    Call<JokeListResponse> getJokesWithFilter(
            @Path("number") String number,
            @Query("exclude") ArrayList<String> category);
}