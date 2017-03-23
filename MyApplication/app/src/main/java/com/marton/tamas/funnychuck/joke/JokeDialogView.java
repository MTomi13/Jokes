package com.marton.tamas.funnychuck.joke;

import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.common.JokeView;

/**
 * Created by tamas.marton on 23/03/2017.
 */

public interface JokeDialogView extends JokeView<Joke> {

    void showProgressRing(int visibility);
}