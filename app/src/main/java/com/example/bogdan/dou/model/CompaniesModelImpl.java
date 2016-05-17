package com.example.bogdan.dou.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

import com.example.bogdan.dou.App;
import com.example.bogdan.dou.R;
import com.example.bogdan.dou.model.data.Company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class CompaniesModelImpl implements CompaniesModel {
    @Inject
    Resources mResources;

    private List<CompaniesModel> mCompanies;

    public CompaniesModelImpl() {
        App.getAppComponent().inject(this);// TODO: 29.04.2016 fix it
    }


    @Override
    public Observable<Company> getCompanies() {
        final Observable<String> name = Observable.from(mResources.getStringArray(R.array.companiesName));
        final Observable<String> url = Observable.from(mResources.getStringArray(R.array.companiesURL));
        final Observable<Integer> imageId = Observable
                .from(R.drawable.class.getFields())
                .map(new Func1<Field, Integer>() {
                    @Override
                    public Integer call(Field field) {
                        System.out.println("Имя" + field.getName());
                        System.out.println(mResources.getIdentifier(field.getName(), "drawable/", null));
                        return mResources.getIdentifier(field.getName(), null, null);
                    }
                });
//                .map(field -> mResources.getIdentifier(field.getName(), null, null));
        return Observable.zip(name, url, imageId, Company::new);
    }

    private List<Drawable> getCompanyIcons() {
        List<Drawable> list = new ArrayList<>();
        for (int i = 1; i < 1153; i++) {
            Drawable icon = ResourcesCompat.getDrawable(mResources, mResources.getIdentifier("company_" + i, null, null), null);
            list.add(icon);
        }
        return list;
    }
}
