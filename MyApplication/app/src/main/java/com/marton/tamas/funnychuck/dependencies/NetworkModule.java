package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.JokeService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        includes = {
                ApplicationModule.class,
        },
        library = true
)
public class NetworkModule {

    @Provides
    JokeRequester provideJokeRequester(JokeService jokeService) {
        return new JokeRequester(jokeService);
    }
}