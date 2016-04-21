package com.example.bogdan.dou;

import android.app.Application;

import com.example.bogdan.dou.di.component.ApiComponent;
import com.example.bogdan.dou.di.component.AppComponent;
import com.example.bogdan.dou.di.component.DaggerApiComponent;
import com.example.bogdan.dou.di.component.DaggerAppComponent;
import com.example.bogdan.dou.di.component.DaggerNetworkComponent;
import com.example.bogdan.dou.di.component.NetworkComponent;
import com.example.bogdan.dou.di.module.AppModule;
import com.example.bogdan.dou.di.module.NetworkModule;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class App extends Application {
    private ApiComponent mApiComponent;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependencies();
    }

    private void resolveDependencies() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.HTTP.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
