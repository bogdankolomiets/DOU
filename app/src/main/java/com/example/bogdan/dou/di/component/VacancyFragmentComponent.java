package com.example.bogdan.dou.di.component;

import com.example.bogdan.dou.di.Lifecycle;
import com.example.bogdan.dou.di.module.VacancyFragmentModule;
import com.example.bogdan.dou.ui.fragment.VacancyFragment;

import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.05.2016
 */
@Lifecycle("fragment")
@Subcomponent(modules = VacancyFragmentModule.class)
public interface VacancyFragmentComponent {
    void inject(VacancyFragment vacancyFragment);
}
