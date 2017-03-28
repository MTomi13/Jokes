package com.marton.tamas.funnychuck.endless_list.model;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class Footer implements Visitable {

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}