package com.marton.tamas.funnychuck.endless_list.model;

import android.view.View;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.endless_list.adapter.viewholder.BaseViewHolder;
import com.marton.tamas.funnychuck.endless_list.adapter.viewholder.JokeViewHolder;
import com.marton.tamas.funnychuck.endless_list.adapter.viewholder.ProgressViewHolder;
import com.marton.tamas.funnychuck.endless_list.adapter.TypeNotSupportedException;

/**
 * Created by tamas.marton on 28/03/2017.
 */

public class TypeFactoryImpl implements TypeFactory {

    @Override
    public int type(Joke joke) {
        return JokeViewHolder.LAYOUT;
    }

    @Override
    public int type(Footer footer) {
        return ProgressViewHolder.LAYOUT;
    }

    @Override
    public BaseViewHolder createViewHolder(View parent, int type) {
        BaseViewHolder createdViewHolder;
        switch (type) {
            case JokeViewHolder.LAYOUT:
                createdViewHolder = new JokeViewHolder(parent);
                break;
            case ProgressViewHolder.LAYOUT:
                createdViewHolder = new ProgressViewHolder(parent);
                break;
            default:
                throw TypeNotSupportedException.create(parent.getContext().getString(R.string.layout_exception, type));
        }
        return createdViewHolder;
    }
}