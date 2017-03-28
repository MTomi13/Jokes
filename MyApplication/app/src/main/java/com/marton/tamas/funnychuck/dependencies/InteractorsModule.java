package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.JokeService;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.text_input.NameChangeInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */

@Module
class InteractorsModule {

    @Provides
    JokeInteractorImpl provideJokeInteractorImpl(JokeRequester jokeRequester) {
        return new JokeInteractorImpl(jokeRequester);
    }

    @Provides
    NameChangeInteractorImpl provideNameChangeInteractor(JokeRequester jokeRequester) {
        return new NameChangeInteractorImpl(jokeRequester);
    }
}