package com.marton.tamas.funnychuck;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marton.tamas.funnychuck.dependencies.ActivityModule;
import com.marton.tamas.funnychuck.util.Constants;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public abstract class BaseFragment extends DialogFragment {

    private ObjectGraph activityGraph;
    protected boolean isFilter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId(), null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activityGraph = ((JokeApplication) getActivity().getApplicationContext()).getApplicationGraph().plus(new ActivityModule(this));
        activityGraph.inject(this);

        isFilter = getArguments().getBoolean(Constants.FILTER_FLAG);
    }

    @Override
    public void onDestroy() {
        activityGraph = null;
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int layoutId();
}
