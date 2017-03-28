package com.marton.tamas.funnychuck.text_input.dagger;

import com.marton.tamas.funnychuck.text_input.NameChangeInteractorImpl;
import com.marton.tamas.funnychuck.text_input.NameChangePresenterImpl;
import com.marton.tamas.funnychuck.text_input.NameChangeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tamas.marton on 28/03/2017.
 */
@Module
public class NameChangeModule {

    private NameChangeView nameChangeView;

    public NameChangeModule(NameChangeView nameChangeView) {
        this.nameChangeView = nameChangeView;
    }

    @Provides
    NameChangeView provideNameChangeView() {
        return nameChangeView;
    }

    @Provides
    NameChangePresenterImpl provideNameChangePresenterImpl(NameChangeInteractorImpl nameChangeInteractor, NameChangeView nameChangeView) {
        return new NameChangePresenterImpl(nameChangeInteractor, nameChangeView);
    }
}