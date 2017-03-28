package com.marton.tamas.funnychuck.endless_list.adapter;

/**
 * Created by tamas.marton on 28/03/2017.
 */

public class TypeNotSupportedException extends RuntimeException {

    private TypeNotSupportedException(String message) {
        super(message);
    }

    public static TypeNotSupportedException create(String message) {
        return new TypeNotSupportedException(message);
    }
}