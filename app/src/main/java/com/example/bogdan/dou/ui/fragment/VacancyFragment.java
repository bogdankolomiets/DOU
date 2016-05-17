package com.example.bogdan.dou.ui.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bogdan.dou.App;
import com.example.bogdan.dou.R;
import com.example.bogdan.dou.di.module.VacancyFragmentModule;
import com.example.bogdan.dou.model.data.Vacancy;
import com.example.bogdan.dou.ui.adapter.VacancyAdapter;
import com.example.bogdan.dou.ui.presenter.base.Presenter;
import com.example.bogdan.dou.ui.presenter.VacancyPresenter;
import com.example.bogdan.dou.ui.view.VacancyView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.04.2016
 */
public class VacancyFragment extends BaseFragment implements VacancyView {

    private final static String BUNDLE_VACANCY_KEY = "VACANCY_KEY";

    @Bind(R.id.vacanciesList)
    RecyclerView mRecyclerView;

    private ProgressDialog mProgressDialog;

    @Inject VacancyPresenter mPresenter;

    VacancyAdapter mAdapter;// TODO: 28.04.2016 provide

    public static VacancyFragment newInstance(String company) {
        VacancyFragment fragment = new VacancyFragment();

        Bundle args = new Bundle();
        args.putString(BUNDLE_VACANCY_KEY, company);
        fragment.setArguments(args);

        return fragment;
    }

    private String getCompany() {
        return getArguments().getString(BUNDLE_VACANCY_KEY);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vacancy_fragment, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new VacancyAdapter(getLayoutInflater(savedInstanceState));// TODO: 28.04.2016 исправить адаптер, и сделать базовый адаптер
        mRecyclerView.setAdapter(mAdapter);
        setupComponent();// TODO: 13.05.16 add this to base fragment or base view
        mPresenter.onVacacies(getCompany());
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

    private void setupComponent() {
        App.getAppComponent()
                .plus(new VacancyFragmentModule(VacancyFragment.this))
                .inject(this);
    }
}
