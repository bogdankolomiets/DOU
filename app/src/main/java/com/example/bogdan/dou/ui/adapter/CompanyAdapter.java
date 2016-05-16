package com.example.bogdan.dou.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.Holder> {
    private final LayoutInflater mLayoutInflater;
    private List<Company> mCompanies;
    private OnVacancyClickListener mListener;

    public CompanyAdapter(LayoutInflater layoutInflater, OnVacancyClickListener listener) {
        mLayoutInflater = layoutInflater;
        mCompanies = new ArrayList<>();
        mListener = listener;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mLayoutInflater.inflate(R.layout.company_row, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Company company = mCompanies.get(position);

        holder.mName.setText(company.getName());
    }

    public void addCompanies(List<Company> companies) {
        mCompanies.addAll(companies);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mCompanies.size();
    }

    public Company getSelectedCompany(int position) {
        return mCompanies.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mName;

        public Holder(android.view.View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());
        }
    }

    public interface OnVacancyClickListener {
        void onClick(int position);
    }

}
