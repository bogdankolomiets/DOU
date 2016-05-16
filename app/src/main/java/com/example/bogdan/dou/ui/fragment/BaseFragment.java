package com.example.bogdan.dou.ui.fragment;

import android.support.v4.app.Fragment;

import com.example.bogdan.dou.ui.presenter.base.Presenter;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public abstract class BaseFragment extends Fragment {

    protected abstract Presenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null)
            getPresenter().onStop();
    }



}
