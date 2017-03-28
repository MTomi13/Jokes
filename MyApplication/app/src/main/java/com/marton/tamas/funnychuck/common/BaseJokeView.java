package com.marton.tamas.funnychuck.common;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface BaseJokeView<T> {

    void showJokes(ArrayList<T> jokes);

    void showError(String error);
}