package com.example.bogdan.dou.di.module;

<<<<<<< HEAD
import com.example.bogdan.dou.model.api.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
=======
import com.example.bogdan.dou.di.UserScope;
import com.example.bogdan.dou.model.api.ApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
>>>>>>> origin/master

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Module
public class ApiModule {
<<<<<<< HEAD
    String mBaseUrl;

    public ApiModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit proviRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory javaCallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(javaCallAdapterFactory)
                .build();
    }

    @Singleton
=======

    @UserScope
>>>>>>> origin/master
    @Provides
    ApiInterface providesApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
