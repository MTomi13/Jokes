package com.marton.tamas.funnychuck.endless_list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;
import com.marton.tamas.funnychuck.endless_list.model.Footer;
import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;

    private ArrayList<Item> jokesArrayList;

    public JokeListAdapter(ArrayList<Item> jokesArrayList) {
        this.jokesArrayList = jokesArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if (jokesArrayList.get(position) instanceof Joke) {
            return TYPE_CONTENT;
        } else {
            return TYPE_FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_joke_list, parent, false);
            viewHolder = new JokeViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.progress_view, parent, false);
            viewHolder = new ProgressViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Item joke = jokesArrayList.get(position);
        if (holder instanceof JokeViewHolder) {
            ((JokeViewHolder) holder).jokeTextView.setText(((Joke) joke).getJoke());
        }
    }

    @Override
    public int getItemCount() {
        return jokesArrayList.size();
    }

    public ArrayList<Item> getJokesArrayList() {
        return jokesArrayList;
    }

    public boolean hasFooter() {
        return jokesArrayList.get(jokesArrayList.size() - 1) instanceof Footer;
    }

    class JokeViewHolder extends BaseViewHolder {

        @BindView(R.id.joke_text)
        TextView jokeTextView;

        JokeViewHolder(final View itemView) {
            super(itemView);
        }
    }

    class ProgressViewHolder extends BaseViewHolder {

        @BindView(R.id.progress_ring)
        ProgressBar progressRing;

        ProgressViewHolder(final View itemView) {
            super(itemView);
        }
    }
}