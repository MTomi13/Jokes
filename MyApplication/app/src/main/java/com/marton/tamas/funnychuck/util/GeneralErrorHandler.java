package com.marton.tamas.funnychuck.util;

import android.app.Activity;
import android.support.design.widget.Snackbar;

/**
 * Created by tamas.marton on 22/03/2017.
 */

public class GeneralErrorHandler {
    /**
     * @param activity show error message
     */
    public static void showErrorMessage(Activity activity, String text) {
        Snackbar.make(activity.getWindow().getDecorView(), text, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}