package com.marton.tamas.funnychuck.dependencies;

import com.marton.tamas.funnychuck.home.HomeActivity;

import dagger.Module;

/**
 * Created by tamas.marton on 21/03/2017.
 */

@Module(
        injects = {
                HomeActivity.class,
        },
        addsTo = NetworkModule.class,
        library = true
)
public class ActivityModule {

    private final HomeActivity homeActivity;

    public ActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }
}