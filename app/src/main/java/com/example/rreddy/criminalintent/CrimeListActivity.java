package com.example.rreddy.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by rreddy on 1/20/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
