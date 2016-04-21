package com.example.bogdan.dou.di.module;

import com.example.bogdan.dou.di.UserScope;
import com.example.bogdan.dou.model.api.ApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Module
public class ApiModule {

    @UserScope
    @Provides
    ApiInterface providesApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
