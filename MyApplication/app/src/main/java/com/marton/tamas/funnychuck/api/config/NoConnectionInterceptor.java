package com.marton.tamas.funnychuck.api.config;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tamas.marton on 21/03/2017.
 */
//custom interceptor to handle no internet connection exception
class NoConnectionInterceptor implements Interceptor {

    private final ConnectivityManager connectivityManager;

    NoConnectionInterceptor(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isConnected()) {
            throw new NoConnectionException();
        }
        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    /**
     * @return NetworkInfo
     * check connection to the internet
     */
    private boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}