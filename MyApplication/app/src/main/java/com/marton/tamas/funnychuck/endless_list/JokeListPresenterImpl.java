package com.marton.tamas.funnychuck.endless_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.marton.tamas.funnychuck.api.model.JokeListResponse;
import com.marton.tamas.funnychuck.common.JokeFetchListener;
import com.marton.tamas.funnychuck.endless_list.model.Visitable;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.random_joke_list_common.JokePresenterImpl;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListPresenterImpl extends JokePresenterImpl implements JokeListPresenter, JokeFetchListener<JokeListResponse> {

    private JokeListView jokeListView;

    public JokeListPresenterImpl(JokeInteractorImpl jokeInteractor, JokeListView jokeListView) {
        super(jokeInteractor);
        this.jokeListView = jokeListView;
        jokeInteractor.setJokeFetchListener(this);
    }

    /**
     * @param linearLayoutManager LinearLayoutManager
     * @param hasFooter           boolean
     *                            add footer progressView to the list
     */
    @Override
    public void addFooterItem(LinearLayoutManager linearLayoutManager, boolean hasFooter) {
        if (!(hasFooter)) {
            //position starts at 0
            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 2) {
                //displays the footer after the onscroll listener
                jokeListView.showListWithFooter();
            }
        }
    }

    /**
     * @param oldJokes ArrayList<Visitable>
     * @param newJokes ArrayList<Visitable>
     *                 remove progress item form the list,
     */
    @Override
    public void insertNewJokes(ArrayList<Visitable> oldJokes, ArrayList<Visitable> newJokes) {
        int arraySize = oldJokes.size();
        oldJokes.remove(arraySize - 1);
        oldJokes.addAll(newJokes);
        jokeListView.showExtendedList(arraySize - 1, oldJokes.size() - arraySize);
    }

    @Override
    public void onFetchJokesSuccess(JokeListResponse jokeListResponse) {
        jokeListView.showJokes(createNewItemList(jokeListResponse));
    }

    @NonNull
    private ArrayList<Visitable> createNewItemList(JokeListResponse jokeListResponse) {
        ArrayList<Visitable> newList = new ArrayList<>();
        newList.addAll(jokeListResponse.getJokeList());
        return newList;
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        jokeListView.showError(errorMessage);
    }
}