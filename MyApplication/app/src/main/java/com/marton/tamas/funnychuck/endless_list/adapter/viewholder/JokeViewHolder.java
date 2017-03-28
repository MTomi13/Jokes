package com.marton.tamas.funnychuck.endless_list.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.TextView;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.api.model.Joke;

import butterknife.BindView;

/**
 * Created by tamas.marton on 28/03/2017.
 */

public class JokeViewHolder extends BaseViewHolder<Joke> {

    @LayoutRes
    public static final int LAYOUT = R.layout.item_joke_list;

    @BindView(R.id.joke_text)
    TextView jokeTextView;

    public JokeViewHolder(final View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Joke element) {
        jokeTextView.setText(element.getJoke());
    }
}