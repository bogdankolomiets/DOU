package com.example.bogdan.dou.di.module;

import android.app.Application;
<<<<<<< HEAD
import android.content.res.Resources;

import com.example.bogdan.dou.App;
=======
>>>>>>> origin/master

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
<<<<<<< HEAD
    private App mApplication;

    public AppModule(App application) {
=======
    private Application mApplication;

    public AppModule(Application application) {
>>>>>>> origin/master
        mApplication = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
<<<<<<< HEAD

    @Singleton
    @Provides
    Resources provideResources() {
        return mApplication.getResources();
    }
=======
>>>>>>> origin/master
}
