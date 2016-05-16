package com.example.bogdan.dou.ui.presenter;

import android.os.Bundle;

import com.example.bogdan.dou.model.CompaniesModelImpl;
import com.example.bogdan.dou.model.data.Company;
import com.example.bogdan.dou.ui.view.CompaniesView;
import com.example.bogdan.dou.ui.view.View;
import com.example.bogdan.dou.ui.presenter.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class CompaniesPresenter extends BasePresenter {
    private CompaniesView mCompaniesView;

    private CompaniesModelImpl mCompaniesModel = new CompaniesModelImpl();// TODO: 29.04.2016 fix it in BasePresenter

    private List<Company> mCompanies = new ArrayList<>();

    @Inject
    public CompaniesPresenter(CompaniesView companiesView) {
        mCompaniesView = companiesView;
    }

    public void onCreateView(Bundle savesInstanceState) {
        onLoading();

        Subscription subscription = mCompaniesModel
                .getCompanies()
                .subscribe(new Observer<Company>() {
                    @Override
                    public void onCompleted() {
                        mCompaniesView.showCompanies(mCompanies);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Company company) {
                        mCompanies.add(company);

                        System.out.println("Размер " + mCompanies.size());
                    }
                });
        addSubscription(subscription);
    }

    @Override
    protected View getView() {
        return mCompaniesView;
    }

    public void onItemSelected(Company company) {
        mCompaniesView.showVacancyFragment(company.getUrl());
    }
}
