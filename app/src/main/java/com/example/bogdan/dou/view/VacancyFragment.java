package com.example.bogdan.dou.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Vacancy;
import com.example.bogdan.dou.view.presenter.Presenter;
import com.example.bogdan.dou.view.presenter.VacancyPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public class VacancyFragment extends BaseFragment implements VacancyView{

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    VacancyPresenter mPresenter = new VacancyPresenter(this);// TODO: 28.04.2016 провайдить презентер

    VacancyAdapter mAdapter;// TODO: 28.04.2016 provide

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vacancy_fragment, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new VacancyAdapter(getLayoutInflater(savedInstanceState));// TODO: 28.04.2016 исправить адаптер, и сделать базовый адаптер
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.onVacacies();
        mPresenter.onCreateView(savedInstanceState);
        return view;
    }

    @Override
    protected Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showVacancies(List<Vacancy> vacancies) {
        mAdapter.addVacancies(vacancies);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
