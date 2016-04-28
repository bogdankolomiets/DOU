package com.example.bogdan.dou.di.component;

import android.app.Application;

<<<<<<< HEAD
import com.example.bogdan.dou.di.module.ApiModule;
import com.example.bogdan.dou.di.module.AppModule;
import com.example.bogdan.dou.model.VacancyModelImpl;
=======
import com.example.bogdan.dou.di.module.AppModule;
>>>>>>> origin/master

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Singleton
<<<<<<< HEAD
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(VacancyModelImpl vacancyModel);

=======
@Component(modules = AppModule.class)
public interface AppComponent {
>>>>>>> origin/master
    Application application();
}
