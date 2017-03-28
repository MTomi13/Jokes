package com.marton.tamas.funnychuck.endless_list.model;

import android.view.View;

import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.endless_list.adapter.viewholder.BaseViewHolder;

/**
 * Created by tamas.marton on 28/03/2017.
 */

public interface TypeFactory {

    int type(Joke joke);

    int type(Footer footer);

    BaseViewHolder createViewHolder(View parent, int type);
}