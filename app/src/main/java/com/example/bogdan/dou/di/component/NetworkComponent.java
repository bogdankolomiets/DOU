package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
