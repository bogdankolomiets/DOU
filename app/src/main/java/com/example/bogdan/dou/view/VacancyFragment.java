package com.example.bogdan.dou.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Vacancy;
import com.example.bogdan.dou.view.presenter.base.Presenter;
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

    private ProgressDialog mProgressDialog;

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
    public void showEmptyList() {
        Toast.makeText(getContext(), "Пока что нет вакансий для этой компании", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("Загрузка");
        mProgressDialog.setMessage("Пожалуйста ожидайте");
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }
}
