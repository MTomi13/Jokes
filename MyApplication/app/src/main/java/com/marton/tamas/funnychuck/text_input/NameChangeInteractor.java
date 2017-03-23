package com.marton.tamas.funnychuck.text_input;

import com.marton.tamas.funnychuck.api.model.Name;
import com.marton.tamas.funnychuck.common.BaseJokeInteractor;

/**
 * Created by tamas.marton on 23/03/2017.
 */

interface NameChangeInteractor extends BaseJokeInteractor {

    void getJokeWithChangedName(Name name);

    void getJokeWithChangedNameAndFilter(Name name);
}