package com.example.bogdan.dou.di.module;

import android.app.Application;
import android.content.res.Resources;

import com.example.bogdan.dou.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Module
public class AppModule {
    private App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    Resources provideResources(Application application) {
        return application.getResources();
    }
}
