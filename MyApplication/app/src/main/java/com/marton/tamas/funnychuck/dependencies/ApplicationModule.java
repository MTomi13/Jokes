package com.marton.tamas.funnychuck.dependencies;

import android.app.Application;

import com.marton.tamas.funnychuck.api.JokeService;
import com.marton.tamas.funnychuck.api.config.ServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        library = true
)
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    JokeService provideConfigurationService() {
        return new ServiceFactory().createJokeService(application.getApplicationContext());
    }
}