package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListFragment;
import com.marton.tamas.funnychuck.endless_list.JokeListPresenterImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListView;
import com.marton.tamas.funnychuck.home.HomeActivity;
import com.marton.tamas.funnychuck.joke.JokeDialogFragment;
import com.marton.tamas.funnychuck.joke.JokeDialogPresenterImpl;
import com.marton.tamas.funnychuck.joke.JokeDialogView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        injects = {
                HomeActivity.class,
                JokeListFragment.class,
                JokeDialogFragment.class
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
    JokeListPresenterImpl provideJokeListPresenterImpl(JokeInteractorImpl jokeInteractor, JokeListView jokeListView) {
        return new JokeListPresenterImpl(jokeInteractor, jokeListView);
    }

    @Provides
    JokeDialogPresenterImpl provideJokeDialogPresenterImpl(JokeInteractorImpl jokeInteractor, JokeDialogView jokeDialogView) {
        return new JokeDialogPresenterImpl(jokeInteractor, jokeDialogView);
    }

    @Provides
    JokeInteractorImpl provideJokeInteractorImpl(JokeRequester jokeRequester) {
        return new JokeInteractorImpl(jokeRequester);
    }

    @Provides
    JokeListView provideJokeListView() {
        return (JokeListView) baseFragment;
    }

    @Provides
    JokeDialogView provideJokeDialogView() {
        return (JokeDialogView) baseFragment;
    }
}