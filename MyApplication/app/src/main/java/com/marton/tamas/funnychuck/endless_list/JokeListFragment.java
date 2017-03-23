package com.marton.tamas.funnychuck.endless_list;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.GeneralErrorHandler;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.endless_list.adapter.JokeListAdapter;
import com.marton.tamas.funnychuck.endless_list.model.Footer;
import com.marton.tamas.funnychuck.endless_list.model.Item;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.util.Constants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListFragment extends BaseFragment implements JokeListView {

    private static final int ANIM_DURATION = 800;
    private static final int REPRESENT_LOADING_DELAY = 5000;
    private static final int MAX_FETCH_JOKES_NUMBER = 20;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    JokeInteractorImpl jokeListInteractor;

    @Inject
    JokeListPresenterImpl jokeListPresenter;

    private JokeListAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_joke_list;
    }

    public static JokeListFragment getInstance(boolean isFilter) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.FILTER_FLAG, isFilter);
        JokeListFragment jokeListFragment = new JokeListFragment();
        jokeListFragment.setArguments(bundle);
        return jokeListFragment;
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbarTitle(getString(R.string.endless_list_title));
        setupRecyclerView();
        jokeListPresenter.getJokes(isFilter, MAX_FETCH_JOKES_NUMBER);
    }

    protected void setToolbarTitle(String title) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(title);
    }

    private void setupRecyclerView() {
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.addOnScrollListener(
                    new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);
                            jokeListPresenter.addFooterItem((LinearLayoutManager) recyclerView.getLayoutManager(), adapter.hasFooter());
                        }
                    }

            );
        }
    }

    @Override
    public void showJokes(ArrayList<Item> jokes) {
        setupRecycleViewAdapter(jokes);
    }

    private void setupRecycleViewAdapter(ArrayList<Item> jokes) {
        if (adapter == null) {
            adapter = new JokeListAdapter(jokes);
            AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
            ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
            scaleAdapter.setDuration(ANIM_DURATION);
            recyclerView.setAdapter(scaleAdapter);
        } else {
            jokeListPresenter.insertNewJokes(adapter.getJokesArrayList(), jokes);
        }
    }

    @Override
    public void showError(String error) {
        GeneralErrorHandler.showErrorMessage(getActivity(), error);
    }

    @Override
    public void showListWithFooter() {
        adapter.getJokesArrayList().add(new Footer());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyItemInserted(adapter.getJokesArrayList().size() - 1);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jokeListPresenter.getJokes(isFilter, MAX_FETCH_JOKES_NUMBER);
            }
        }, REPRESENT_LOADING_DELAY);
    }

    @Override
    public void showExtendedList(int positionStart, int itemCount) {
        adapter.notifyItemRangeChanged(positionStart, itemCount);
    }
}