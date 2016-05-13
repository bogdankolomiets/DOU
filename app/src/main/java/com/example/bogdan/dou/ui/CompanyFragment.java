package com.example.bogdan.dou.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Company;
import com.example.bogdan.dou.ui.presenter.CompaniesPresenter;
import com.example.bogdan.dou.ui.presenter.base.Presenter;
import com.example.bogdan.dou.ui.view.CompaniesView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class CompanyFragment extends BaseFragment implements CompaniesView {
    @Bind(R.id.companiesList)
    RecyclerView mRecyclerView;

    private CompanyAdapter mCompanyAdapter;

    CompaniesPresenter mCompaniesPresenter = new CompaniesPresenter(this);// TODO: 29.04.2016 fix it

    private ProgressDialog mProgressDialog; // TODO: 29.04.2016 fix it

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.companies_fragment, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(llm);

        mCompanyAdapter = new CompanyAdapter(getLayoutInflater(savedInstanceState));
        mRecyclerView.setAdapter(mCompanyAdapter);

        mCompaniesPresenter.onCreateView(savedInstanceState);
        return view;
    }
    @Override
    protected Presenter getPresenter() {
        return mCompaniesPresenter;
    }

    @Override
    public void showCompanies(List<Company> companies) {
        mCompanyAdapter.addCompanies(companies);
    }



    @Override
    public void showVacancyFragment(String company) {

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
