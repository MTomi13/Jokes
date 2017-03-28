package com.marton.tamas.funnychuck.dependencies;

import android.app.Application;

import com.marton.tamas.funnychuck.api.JokeRequester;
import com.marton.tamas.funnychuck.api.JokeService;
import com.marton.tamas.funnychuck.api.config.ServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */


@Module
public class DomainModule {

    private final Application application;

    public DomainModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    JokeService provideConfigurationService() {
        return new ServiceFactory().createJokeService(application.getApplicationContext());
    }

    @Provides
    @Singleton
    JokeRequester provideJokeRequester(JokeService jokeService) {
        return new JokeRequester(jokeService);
    }
}