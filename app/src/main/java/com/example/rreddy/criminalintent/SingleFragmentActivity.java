package com.example.rreddy.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by rreddy on 1/20/2015.
 */
public abstract class SingleFragmentActivity extends ActionBarActivity // FragmentActivity can't be
// used with AppCompat Theme - refer to android:theme="@style/AppTheme" in the manifest file
{
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) { // if the Activity - and thereby Fragment - gets shutdown and recreated
            // when, say portrait to landscape, the fragment created earlier (and saved in "fragmentContainer")
            // gets reused.
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}