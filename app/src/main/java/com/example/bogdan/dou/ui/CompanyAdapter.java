package com.example.bogdan.dou.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

    public CompanyAdapter(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
        mCompanies = new ArrayList<>();
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

    public class Holder extends RecyclerView.ViewHolder {
        private TextView mName;

        public Holder(android.view.View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
