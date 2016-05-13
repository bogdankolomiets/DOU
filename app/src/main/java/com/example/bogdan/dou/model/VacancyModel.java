package com.example.bogdan.dou.model;

import com.example.bogdan.dou.model.data.Vacancy;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public interface VacancyModel {
    Observable getVacancyList(String company);
}
