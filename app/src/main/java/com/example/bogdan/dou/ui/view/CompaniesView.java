package com.example.bogdan.dou.ui.view;

import com.example.bogdan.dou.model.data.Company;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public interface CompaniesView extends View {

    void showCompanies(List<Company> companies);

    void showVacancies(String company);


}
