package com.example.bogdan.dou.view;

import com.example.bogdan.dou.model.data.Vacancy;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public interface VacancyView {

    void showVacancies(List<Vacancy> vacancies);

    void showError(String error);

    void showLoading();

    void hideLoading();
}
