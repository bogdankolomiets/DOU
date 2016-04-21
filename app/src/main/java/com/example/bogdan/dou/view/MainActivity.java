package com.example.bogdan.dou.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.bogdan.dou.R;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private static final int LAYOUT = R.layout.main_layout;

    private FragmentManager mFragmentManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        mFragmentManager = getSupportFragmentManager();

        Fragment fragment = mFragmentManager.findFragmentByTag(TAG);
        if (fragment == null)
            replaceFragment(new VacancyFragment(), false);

    }

    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);

        if (addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
}
