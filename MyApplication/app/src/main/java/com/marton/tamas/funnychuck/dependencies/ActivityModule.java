package com.marton.tamas.funnychuck.dependencies;

import android.content.Context;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.endless_list.JokeListFragment;
import com.marton.tamas.funnychuck.endless_list.JokeListInteractorImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListPresenterImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListView;
import com.marton.tamas.funnychuck.home.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        injects = {
                HomeActivity.class,
                BaseFragment.class,
                JokeListFragment.class
        },
        addsTo = NetworkModule.class,
        library = true
)
public class ActivityModule {

    private final BaseFragment baseFragment;

    public ActivityModule(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    @Provides
    JokeListPresenterImpl provideJokeListPresenterImpl(JokeListInteractorImpl jokeListInteractor, JokeListView jokeListView) {
        return new JokeListPresenterImpl(jokeListInteractor, jokeListView);
    }

    @Provides
    JokeListInteractorImpl provideJokeListInteractorImpl(JokeRequester jokeRequester) {
        return new JokeListInteractorImpl(jokeRequester);
    }

    @Provides
    JokeListView provideJokeListView() {
        return (JokeListView) baseFragment;
    }
}