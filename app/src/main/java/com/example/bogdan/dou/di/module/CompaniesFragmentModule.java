package com.example.bogdan.dou.di.module;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.ui.fragment.CompanyFragment;
import com.example.bogdan.dou.ui.presenter.CompaniesPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.05.16
 */
@Module
public class CompaniesFragmentModule {
    protected CompanyFragment fragment;

    public CompaniesFragmentModule(CompanyFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Lifecycle("fragment")
    public CompaniesPresenter provideCompaniesPresenter() {
        return new CompaniesPresenter(fragment);
    }

}
