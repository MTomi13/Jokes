package com.marton.tamas.funnychuck.api.config;

import java.io.IOException;

/**
 * Created by tamas.marton on 21/03/2017.
 */

class NoConnectionException extends IOException {

    @Override
    public String getMessage() {
        return "To use the application, you need internet connection!";
    }
}