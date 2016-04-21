package com.example.bogdan.dou.di.component;

import android.app.Application;

import com.example.bogdan.dou.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();
}
