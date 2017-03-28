package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.JokeApplication;
import com.marton.tamas.funnychuck.random_joke_list_common.JokeInteractorImpl;
import com.marton.tamas.funnychuck.text_input.NameChangeInteractorImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DomainModule.class,
                InteractorsModule.class
        }
)
public interface ApplicationComponent {
    void inject(JokeApplication jokeApplication);

    JokeInteractorImpl getJokeInteractorImpl();

    NameChangeInteractorImpl getNameChangeInteractorImpl();
}