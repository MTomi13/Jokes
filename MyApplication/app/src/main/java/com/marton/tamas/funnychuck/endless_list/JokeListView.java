package com.marton.tamas.funnychuck.endless_list;

import com.marton.tamas.funnychuck.common.BaseJokeView;
import com.marton.tamas.funnychuck.endless_list.model.Item;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public interface JokeListView extends BaseJokeView<Item> {

    void showListWithFooter();

    void showExtendedList(int positionStart, int itemCount);
}