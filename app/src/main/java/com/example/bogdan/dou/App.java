package com.example.bogdan.dou;

import android.app.Application;

<<<<<<< HEAD
import com.example.bogdan.dou.di.component.AppComponent;
import com.example.bogdan.dou.di.component.DaggerAppComponent;
import com.example.bogdan.dou.di.module.ApiModule;
import com.example.bogdan.dou.di.module.AppModule;
=======
import com.example.bogdan.dou.di.component.ApiComponent;
import com.example.bogdan.dou.di.component.AppComponent;
import com.example.bogdan.dou.di.component.DaggerApiComponent;
import com.example.bogdan.dou.di.component.DaggerAppComponent;
import com.example.bogdan.dou.di.component.DaggerNetworkComponent;
import com.example.bogdan.dou.di.component.NetworkComponent;
import com.example.bogdan.dou.di.module.AppModule;
import com.example.bogdan.dou.di.module.NetworkModule;
>>>>>>> origin/master

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class App extends Application {
<<<<<<< HEAD
    private static AppComponent mAppComponent;
=======
    private ApiComponent mApiComponent;
    private AppComponent mAppComponent;
>>>>>>> origin/master

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependencies();
    }

    private void resolveDependencies() {
<<<<<<< HEAD
        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(Constants.HTTP.BASE_URL))
=======
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
        mAppComponent = DaggerAppComponent.builder()
>>>>>>> origin/master
                .appModule(new AppModule(this))
                .build();
    }

<<<<<<< HEAD

    public static AppComponent getAppComponent() {
=======
    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.HTTP.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    public AppComponent getAppComponent() {
>>>>>>> origin/master
        return mAppComponent;
    }
}
