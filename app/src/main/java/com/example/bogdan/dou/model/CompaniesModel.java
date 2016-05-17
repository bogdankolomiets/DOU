package com.example.bogdan.dou.model;

import android.graphics.drawable.Drawable;

import com.example.bogdan.dou.model.data.Company;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public interface CompaniesModel {
    Observable<Company> getCompanies();
}
