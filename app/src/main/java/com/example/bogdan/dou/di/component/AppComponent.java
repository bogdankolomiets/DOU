package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.di.module.ApiModule;
import com.example.bogdan.dou.di.module.AppModule;
import com.example.bogdan.dou.di.module.VacancyFragmentModule;
import com.example.bogdan.dou.model.CompaniesModelImpl;
import com.example.bogdan.dou.model.VacancyModelImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    VacancyFragmentComponent plus(VacancyFragmentModule vacancyFragmentModule);

    void inject(VacancyModelImpl vacancyModel);

    void inject(CompaniesModelImpl companiesModel);

}
