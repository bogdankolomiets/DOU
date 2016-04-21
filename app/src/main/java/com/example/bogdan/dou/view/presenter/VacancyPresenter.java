package com.example.bogdan.dou.view.presenter;

import android.os.Bundle;

import com.example.bogdan.dou.model.data.Vacancy;
import com.example.bogdan.dou.view.VacancyView;

import java.util.List;

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

    public VacancyPresenter(VacancyView vacancyView) {
        mVacancyView = vacancyView;
    }

    public void onVacacies() {
        String company = "epam-systems";

        Subscription subscription = mVacancyModel
                .getVacancyList(company)
                .subscribe(new Observer<List<Vacancy>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onNext(List<Vacancy> vacancies) {
                        if (vacancies != null && !vacancies.isEmpty()) {
                            mVacancies = vacancies;
                            mVacancyView.showVacancies(vacancies);
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
        return mVacancies != null && !mVacancies.isEmpty();
    }
}
