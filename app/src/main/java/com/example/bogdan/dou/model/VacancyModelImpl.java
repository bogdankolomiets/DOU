package com.example.bogdan.dou.model;

import com.example.bogdan.dou.App;
import com.example.bogdan.dou.model.api.ApiInterface;
import com.example.bogdan.dou.model.data.Vacancy;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public class VacancyModelImpl implements VacancyModel {
    private final Observable.Transformer schedulerTransformer;
    
    @Inject
    ApiInterface mApiInterface;

    public VacancyModelImpl() {
        App.getAppComponent().inject(this);
        schedulerTransformer = o ->((Observable) o).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<Vacancy>> getVacancyList(String company) {
        return mApiInterface
                .getVacancies(company)
                .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulerTransformer;
    }
}
