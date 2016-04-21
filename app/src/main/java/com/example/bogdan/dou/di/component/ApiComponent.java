package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.MainActivity;
import com.example.bogdan.dou.di.UserScope;
import com.example.bogdan.dou.di.module.ApiModule;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@UserScope
@Component(dependencies = NetworkComponent.class, modules = ApiModule.class)
public interface ApiComponent {
    void inject(MainActivity mainActivity);
}
