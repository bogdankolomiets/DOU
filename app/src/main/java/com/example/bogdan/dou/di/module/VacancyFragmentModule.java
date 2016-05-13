package com.example.bogdan.dou.di.module;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.ui.VacancyFragment;
import com.example.bogdan.dou.ui.presenter.VacancyPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bogdan on 13.05.16.
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
