package com.example.bogdan.dou.model;

import android.content.res.Resources;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Company;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class CompaniesModelImpl implements CompaniesModel {
    @Inject
    Resources mResources;

    private List<CompaniesModel> mCompanies;


    @Override
    public Observable<Company> getCompanies() {
        final Observable<String> name = Observable.from(mResources.getStringArray(R.array.companiesName));
        final Observable<String> url = Observable.from(mResources.getStringArray(R.array.companiesURL));

        return Observable.zip(name, url, Company::new);
    }
}
