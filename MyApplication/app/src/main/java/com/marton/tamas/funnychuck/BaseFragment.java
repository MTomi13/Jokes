package com.marton.tamas.funnychuck;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marton.tamas.funnychuck.dependencies.ActivityModule;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public abstract class BaseFragment extends Fragment {

    private ObjectGraph activityGraph;

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
    }

    protected void setToolbarTitle(String title) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(title);
    }

    @Override
    public void onDestroy() {
        activityGraph = null;
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int layoutId();
}
