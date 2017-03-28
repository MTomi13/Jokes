package com.marton.tamas.funnychuck.endless_list.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.ProgressBar;

import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.endless_list.model.Footer;

import butterknife.BindView;

/**
 * Created by tamas.marton on 28/03/2017.
 */

public class ProgressViewHolder extends BaseViewHolder<Footer> {

    @LayoutRes
    public static final int LAYOUT = R.layout.item_progress_view;

    @BindView(R.id.progress_ring)
    ProgressBar progressRing;

    public ProgressViewHolder(final View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Footer element) {

    }
}