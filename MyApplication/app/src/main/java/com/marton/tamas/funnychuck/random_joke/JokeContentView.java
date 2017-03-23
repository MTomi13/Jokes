package com.marton.tamas.funnychuck.random_joke;

import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.common.BaseJokeView;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokeContentView extends BaseJokeView<Joke> {

    void showProgressRing(int visibility);
}