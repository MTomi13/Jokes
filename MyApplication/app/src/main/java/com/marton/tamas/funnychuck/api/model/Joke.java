package com.marton.tamas.funnychuck.api.model;

import com.google.gson.annotations.Expose;
import com.marton.tamas.funnychuck.endless_list.model.Item;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class Joke extends Item{

    @Expose
    private Integer id;
    @Expose
    private String joke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}