package com.marton.tamas.funnychuck.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListResponse {

    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private ArrayList<Joke> jokeList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Joke> getJokeList() {
        return jokeList;
    }

    public void setJokeList(ArrayList<Joke> jokeList) {
        this.jokeList = jokeList;
    }

}