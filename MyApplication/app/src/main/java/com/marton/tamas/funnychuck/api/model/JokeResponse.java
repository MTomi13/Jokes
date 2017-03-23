package com.marton.tamas.funnychuck.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public class JokeResponse {

    @Expose
    private String type;

    @SerializedName("value")
    @Expose
    private Joke joke;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
