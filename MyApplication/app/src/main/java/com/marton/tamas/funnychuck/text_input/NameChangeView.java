package com.marton.tamas.funnychuck.text_input;

import com.marton.tamas.funnychuck.api.model.Joke;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface NameChangeView {

    void showJoke(Joke joke);

    void showError(String error);

    void showProgressRing(int visibility);
}