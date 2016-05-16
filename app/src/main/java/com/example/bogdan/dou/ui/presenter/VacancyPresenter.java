package com.example.bogdan.dou.ui.presenter;

import android.os.Bundle;

import com.example.bogdan.dou.model.data.Vacancy;
import com.example.bogdan.dou.ui.view.VacancyView;
import com.example.bogdan.dou.ui.view.View;
import com.example.bogdan.dou.ui.presenter.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public class VacancyPresenter extends BasePresenter {
    private VacancyView mVacancyView;

    private List<Vacancy> mVacancies;

    @Inject
    public VacancyPresenter(VacancyView vacancyView) {
        mVacancyView = vacancyView;
    }

    public void onVacacies(String company) {
        onLoading();
        Subscription subscription = mVacancyModel
                .getVacancyList(company)
                .subscribe(new Observer<List<Vacancy>>() {
                    @Override
                    public void onCompleted() {
                        onStopLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onErr(e);
                    }

                    @Override
                    public void onNext(List<Vacancy> vacancies) {
                        if (vacancies != null && !vacancies.isEmpty()) {
                            mVacancies = vacancies;
                            mVacancyView.showVacancies(vacancies);
                        } else {
                            mVacancyView.showEmptyList();
                        }
                    }
                });
        addSubscription(subscription);
    }

    public void onCreateView(Bundle savedInstanceState) {
        if (isVacancyListNotEmpty())
            mVacancyView.showVacancies(mVacancies);
    }

    private boolean isVacancyListNotEmpty() {
        return (mVacancies != null && !mVacancies.isEmpty());
    }

    @Override
    protected View getView() {
        return mVacancyView;
    }

    public void onCompaniesClick() {
        mVacancyView.showCompaniesFragment();
    }
}
