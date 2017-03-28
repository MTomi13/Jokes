package com.marton.tamas.funnychuck.endless_list;

import android.support.v7.widget.LinearLayoutManager;

import com.marton.tamas.funnychuck.endless_list.model.Visitable;
import com.marton.tamas.funnychuck.random_joke_list_common.JokePresenter;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

interface JokeListPresenter extends JokePresenter {

    void addFooterItem(LinearLayoutManager linearLayoutManager, boolean hasFooter);

    void insertNewJokes(ArrayList<Visitable> oldJokes, ArrayList<Visitable> newJokes);
}