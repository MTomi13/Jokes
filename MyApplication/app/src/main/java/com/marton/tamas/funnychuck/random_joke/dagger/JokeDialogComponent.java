package com.marton.tamas.funnychuck.random_joke.dagger;

import com.marton.tamas.funnychuck.dependencies.ActivityScope;
import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.random_joke.JokeDialogFragment;

import dagger.Component;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = JokeDialogModule.class
)
public interface JokeDialogComponent {

    void inject(JokeDialogFragment fragment);
}