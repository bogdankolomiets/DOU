package com.example.bogdan.dou.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bogdan.dou.R;
import com.example.bogdan.dou.ui.fragment.CompanyFragment;
import com.example.bogdan.dou.ui.fragment.VacancyFragment;
import com.example.bogdan.dou.ui.view.ActivityCallback;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
public class MainActivity extends AppCompatActivity implements ActivityCallback {
    private static final String TAG = "CompanyFragment";
    private static final int LAYOUT = R.layout.main_layout;

    private FragmentManager mFragmentManager;

    private Toolbar mToolbar;// TODO: 29.04.2016 provide

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mFragmentManager = getSupportFragmentManager();

        Fragment fragment = mFragmentManager.findFragmentByTag(TAG);
        if (fragment == null)
            replaceFragment(new CompanyFragment());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() > 0)
            popFragmentFromBackStack();
        else
            super.onBackPressed();
    }

    @Override
    public void popFragmentFromBackStack() {
        mFragmentManager.popBackStack();
    }
}
