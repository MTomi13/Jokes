package com.marton.tamas.funnychuck.endless_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.marton.tamas.funnychuck.api.model.JokeResponse;
import com.marton.tamas.funnychuck.endless_list.JokeListInteractorImpl.JokeListInteractorListener;
import com.marton.tamas.funnychuck.endless_list.model.Item;

import java.util.ArrayList;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class JokeListPresenterImpl implements JokeListPresenter, JokeListInteractorListener {

    private JokeListInteractorImpl jokeListInteractor;
    private JokeListView jokeListView;

    public JokeListPresenterImpl(JokeListInteractorImpl jokeListInteractor, JokeListView jokeListView) {
        this.jokeListInteractor = jokeListInteractor;
        this.jokeListView = jokeListView;
    }

    @Override
    public void getJokes(boolean isFilterNeeded) {
        jokeListInteractor.setJokeListInteractorListener(this);
        if (isFilterNeeded) {
            jokeListInteractor.getFilteredJokesFromApi();
        } else {
            jokeListInteractor.getJokesFromApi();
        }
    }

    @Override
    public void insertNewJokes(ArrayList<Item> oldJokes, ArrayList<Item> newJokes) {
        int arraySize = oldJokes.size();
        oldJokes.remove(arraySize - 1);
        oldJokes.addAll(newJokes);
        jokeListView.showExtendedList(arraySize - 1, oldJokes.size() - arraySize);
    }

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

    @Override
    public void onFetchJokesSuccess(JokeResponse jokeResponse) {
        jokeListView.showJokes(createNewItemList(jokeResponse));
    }

    @NonNull
    private ArrayList<Item> createNewItemList(JokeResponse jokeResponse) {
        ArrayList<Item> newList = new ArrayList<>();
        newList.addAll(jokeResponse.getJokeList());
        return newList;
    }

    @Override
    public void onFetchJokesFailed(String errorMessage) {
        jokeListView.showError(errorMessage);
    }
}