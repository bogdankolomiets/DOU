package com.example.bogdan.dou;

import android.app.Application;

import com.example.bogdan.dou.di.component.AppComponent;
import com.example.bogdan.dou.di.component.DaggerAppComponent;
import com.example.bogdan.dou.di.module.ApiModule;
import com.example.bogdan.dou.di.module.AppModule;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class App extends Application {
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependencies();
    }

    private void resolveDependencies() {
        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(Constants.HTTP.BASE_URL))
                .appModule(new AppModule(this))
                .build();
    }


    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
