package com.marton.tamas.funnychuck.endless_list.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(T element);
}