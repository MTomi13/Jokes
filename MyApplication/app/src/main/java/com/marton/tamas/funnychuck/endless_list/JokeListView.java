package com.marton.tamas.funnychuck.endless_list;

import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeListView {

    void showJokes(ArrayList<Item> jokes);

    void showError(String error);

    void showListWithFooter();

    void showExtendedList(int positionStart, int itemCount);
}