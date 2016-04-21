package com.example.bogdan.dou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bogdan.dou.model.api.ApiInterface;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class MainActivity extends AppCompatActivity {
    @Inject
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void resolveDependency() {
        ((App) getApplication()).getApiComponent().inject(this);
    }
}
