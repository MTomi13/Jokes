package com.marton.tamas.funnychuck.endless_list.dagger;

import com.marton.tamas.funnychuck.dependencies.ActivityScope;
import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.endless_list.JokeListFragment;

import dagger.Component;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = JokeListModule.class
)
public interface JokeListComponent {

    void inject(JokeListFragment fragment);
}
