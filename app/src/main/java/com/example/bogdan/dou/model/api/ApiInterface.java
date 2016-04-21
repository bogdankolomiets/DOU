package com.example.bogdan.dou.model.api;

import com.example.bogdan.dou.model.data.Vacancy;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public interface ApiInterface {

    @GET("companies/{company}/vacancies/export/")
    Observable<List<Vacancy>> getVacancies(@Path("company") String company);
}
