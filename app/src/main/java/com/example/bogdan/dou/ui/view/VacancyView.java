package com.example.bogdan.dou.ui.view;

import com.example.bogdan.dou.model.data.Vacancy;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public interface VacancyView extends View {

    void showVacancies(List<Vacancy> vacancies);

    void showEmptyList();


}
