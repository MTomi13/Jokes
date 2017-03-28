package com.marton.tamas.funnychuck;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.util.Constants;

import butterknife.ButterKnife;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public abstract class BaseFragment extends DialogFragment {

    protected boolean isFilter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        view = inflater.inflate(layoutId(), null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retain this Fragment so that it will not be destroyed when an orientation change
        setRetainInstance(true);
        setupDagger();
        isFilter = getArguments().getBoolean(Constants.FILTER_FLAG);
    }

    /**
     * setup activityGraph
     */
    private void setupDagger() {
        setupComponent(JokeApplication.get(getActivity()).component());
    }

    @LayoutRes
    protected abstract int layoutId();

    protected abstract void setupComponent(ApplicationComponent applicationComponent);
}