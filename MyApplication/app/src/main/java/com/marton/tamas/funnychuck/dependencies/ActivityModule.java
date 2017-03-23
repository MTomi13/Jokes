package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.BaseFragment;
import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.endless_list.JokeListFragment;
import com.marton.tamas.funnychuck.endless_list.JokeListPresenterImpl;
import com.marton.tamas.funnychuck.endless_list.JokeListView;
import com.marton.tamas.funnychuck.home.HomeActivity;
import com.marton.tamas.funnychuck.random_joke.JokeContentView;
import com.marton.tamas.funnychuck.random_joke.JokeDialogFragment;
import com.marton.tamas.funnychuck.random_joke.JokeDialogPresenterImpl;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.text_input.NameChangeFragment;
import com.marton.tamas.funnychuck.text_input.NameChangeInteractorImpl;
import com.marton.tamas.funnychuck.text_input.NameChangePresenterImpl;
import com.marton.tamas.funnychuck.text_input.NameChangeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        injects = {
                HomeActivity.class,
                JokeListFragment.class,
                JokeDialogFragment.class,
                NameChangeFragment.class
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
    JokeDialogPresenterImpl provideJokeDialogPresenterImpl(JokeInteractorImpl jokeInteractor, JokeContentView jokeContentView) {
        return new JokeDialogPresenterImpl(jokeInteractor, jokeContentView);
    }

    @Provides
    JokeInteractorImpl provideJokeInteractorImpl(JokeRequester jokeRequester) {
        return new JokeInteractorImpl(jokeRequester);
    }

    @Provides
    NameChangePresenterImpl provideNameChangePresenterImpl(NameChangeInteractorImpl nameChangeInteractor, NameChangeView nameChangeView) {
        return new NameChangePresenterImpl(nameChangeInteractor, nameChangeView);
    }

    @Provides
    NameChangeInteractorImpl provideNameChangeInteractorImpl(JokeRequester jokeRequester) {
        return new NameChangeInteractorImpl(jokeRequester);
    }

    @Provides
    JokeListView provideJokeListView() {
        return (JokeListView) baseFragment;
    }

    @Provides
    JokeContentView provideJokeContentView() {
        return (JokeContentView) baseFragment;
    }

    @Provides
    NameChangeView provideNameChangeView() {
        return (NameChangeView) baseFragment;
    }
}