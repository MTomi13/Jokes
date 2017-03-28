package com.marton.tamas.funnychuck.endless_list.model;

/**
 * Created by tamas.marton on 28/03/2017.
 */
// use visitor pattern to separate a complex set of structured data classes from the functionality
// use it to handle different types in the adapter
public interface Visitable {

    int type(TypeFactory typeFactory);
}