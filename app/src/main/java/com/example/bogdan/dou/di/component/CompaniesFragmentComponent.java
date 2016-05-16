package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.di.module.CompaniesFragmentModule;
import com.example.bogdan.dou.ui.fragment.CompanyFragment;

import dagger.Component;
import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.05.16
 */
@Lifecycle("fragment")
@Subcomponent(modules = CompaniesFragmentModule.class)
public interface CompaniesFragmentComponent {
    void inject(CompanyFragment fragment);
}
