package com.example.bogdan.dou.view.presenter.base;

import com.example.bogdan.dou.model.VacancyModelImpl;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public abstract class BasePresenter implements Presenter {

    public VacancyModelImpl mVacancyModel = new VacancyModelImpl();// TODO: 28.04.2016 сделать провайдинг модели

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();// TODO: 28.04.2016 provide comSub

    protected void addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void onStop() {
        mCompositeSubscription.clear();
    }




}
