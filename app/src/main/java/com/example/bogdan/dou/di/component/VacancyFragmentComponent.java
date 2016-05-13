package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.di.module.VacancyFragmentModule;
import com.example.bogdan.dou.ui.VacancyFragment;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by bogdan on 13.05.16.
 */
@Lifecycle("fragment")
@Subcomponent(modules = VacancyFragmentModule.class)
public interface VacancyFragmentComponent {
    void inject(VacancyFragment vacancyFragment);
}
