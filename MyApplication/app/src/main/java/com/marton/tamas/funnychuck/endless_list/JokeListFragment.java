package com.marton.tamas.funnychuck.endless_list;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.R;
import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.endless_list.dagger.DaggerJokeListComponent;
import com.marton.tamas.funnychuck.endless_list.dagger.JokeListModule;
import com.marton.tamas.funnychuck.endless_list.adapter.JokeListAdapter;
import com.marton.tamas.funnychuck.endless_list.model.Footer;
import com.marton.tamas.funnychuck.endless_list.model.TypeFactoryImpl;
import com.marton.tamas.funnychuck.endless_list.model.Visitable;
import com.marton.tamas.funnychuck.util.Constants;
import com.marton.tamas.funnychuck.util.GeneralErrorHandler;

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

    // delay to represent the progressbar
    private static final int REPRESENT_LOADING_DELAY = 4000;
    private static final int MAX_FETCH_JOKES_NUMBER = 20;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    JokeListPresenterImpl jokeListPresenter;

    private JokeListAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_joke_list;
    }

    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        DaggerJokeListComponent.builder()
                .applicationComponent(applicationComponent)
                .jokeListModule(new JokeListModule(this))
                .build()
                .inject(this);
    }

    public static JokeListFragment getInstance(boolean isFilter) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.FILTER_FLAG, isFilter);
        JokeListFragment jokeListFragment = new JokeListFragment();
        jokeListFragment.setArguments(bundle);
        return jokeListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jokeListPresenter.getJokes(isFilter, MAX_FETCH_JOKES_NUMBER);
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
    public void showJokes(ArrayList<Visitable> jokes) {
        setupRecyclerView();
        setupRecycleViewAdapter(jokes);
    }

    /**
     * @param jokes ArrayList<Visitable>
     *              setup recyclerview adapter, if it is null, create it with animation,
     *              if it is exist just insert the new jokes
     */
    private void setupRecycleViewAdapter(ArrayList<Visitable> jokes) {
        if (adapter == null) {
            adapter = new JokeListAdapter(jokes, new TypeFactoryImpl());
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

    /**
     * add Footer progress view item to the list, and start fetching the new items
     */
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