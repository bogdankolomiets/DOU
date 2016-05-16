package com.example.bogdan.dou.di.module;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.ui.fragment.VacancyFragment;
import com.example.bogdan.dou.ui.presenter.VacancyPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.05.2016
 */
@Module
public class VacancyFragmentModule {
    protected VacancyFragment fragment;

    public VacancyFragmentModule(VacancyFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Lifecycle("fragment")
    public VacancyPresenter provideVacancyPresenter() {
        return new VacancyPresenter(fragment);
    }
}
