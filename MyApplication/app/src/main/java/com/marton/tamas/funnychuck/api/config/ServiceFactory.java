package com.marton.tamas.funnychuck.api.config;

import android.content.Context;
import android.net.ConnectivityManager;

import com.marton.tamas.funnychuck.api.JokeService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tamas.marton on 21/03/2017.
 */

public class ServiceFactory {

    private static final String API_ENDPOINT = "http://api.icndb.com/jokes/";

    /**
     * @return JokeService
     * create retrofit builder for SearchService
     */
    public JokeService createJokeService(Context context) {
        return getBuilder(context).build().create(JokeService.class);
    }

    private Retrofit.Builder getBuilder(Context context) {
        return getRestAdapterBuilder(new OkHttpClient.Builder()
                .addInterceptor(setupLogger())
                .addInterceptor(new NoConnectionInterceptor((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)))
                .build(), API_ENDPOINT);
    }

    /**
     * @param client          client
     * @param serviceEndpoint serviceEndpoint
     * @return Retrofit.Builder
     * setup RestAdapter builder, with HttpClient, GsonConverter, baseUrl
     */
    private Retrofit.Builder getRestAdapterBuilder(OkHttpClient client, String serviceEndpoint) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(serviceEndpoint);
        builder.client(client);
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder;
    }

    /**
     * @return HttpLoggingInterceptor
     * setup LoggingInterceptor to log every Retrofit logs
     */
    private HttpLoggingInterceptor setupLogger() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}