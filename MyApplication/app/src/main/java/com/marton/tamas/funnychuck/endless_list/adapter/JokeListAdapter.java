package com.marton.tamas.funnychuck.endless_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marton.tamas.funnychuck.endless_list.adapter.viewholder.BaseViewHolder;
import com.marton.tamas.funnychuck.endless_list.model.Footer;
import com.marton.tamas.funnychuck.endless_list.model.TypeFactory;
import com.marton.tamas.funnychuck.endless_list.model.Visitable;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<Visitable> jokesArrayList;
    private final TypeFactory typeFactory;

    public JokeListAdapter(ArrayList<Visitable> jokesArrayList, TypeFactory typeFactory) {
        this.jokesArrayList = jokesArrayList;
        this.typeFactory = typeFactory;
    }

    @Override
    public int getItemViewType(int position) {
        return jokesArrayList.get(position).type(typeFactory);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return typeFactory.createViewHolder(contactView, viewType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(jokesArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return jokesArrayList.size();
    }

    public ArrayList<Visitable> getJokesArrayList() {
        return jokesArrayList;
    }

    public boolean hasFooter() {
        return jokesArrayList.get(jokesArrayList.size() - 1) instanceof Footer;
    }
}