package com.marton.tamas.funnychuck.text_input.dagger;

import com.marton.tamas.funnychuck.dependencies.ActivityScope;
import com.marton.tamas.funnychuck.dependencies.ApplicationComponent;
import com.marton.tamas.funnychuck.text_input.NameChangeFragment;

import dagger.Component;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = NameChangeModule.class
)
public interface NameChangeComponent {

    void inject(NameChangeFragment fragment);
}