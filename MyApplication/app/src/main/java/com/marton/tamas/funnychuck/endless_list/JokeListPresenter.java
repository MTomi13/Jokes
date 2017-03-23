package com.marton.tamas.funnychuck.endless_list;

import android.support.v7.widget.LinearLayoutManager;

import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeListPresenter {

    void getJokes(boolean isFilterNeeded);

    void addFooterItem(LinearLayoutManager linearLayoutManager, boolean hasFooter);

    void insertNewJokes(ArrayList<Item> oldJokes, ArrayList<Item> newJokes);
}
