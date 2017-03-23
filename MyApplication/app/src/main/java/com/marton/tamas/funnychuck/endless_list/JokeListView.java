package com.marton.tamas.funnychuck.endless_list;

import com.marton.tamas.funnychuck.common.JokeView;
import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeListView extends JokeView<Item> {

    void showListWithFooter();

    void showExtendedList(int positionStart, int itemCount);
}