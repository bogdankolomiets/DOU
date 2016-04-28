package com.example.bogdan.dou.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Module
public class NetworkModule {
    String mBaseUrl;

    public NetworkModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(mBaseUrl)
                .build();
    }
}
