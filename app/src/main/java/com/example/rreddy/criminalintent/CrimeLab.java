package com.example.rreddy.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by rreddy on 1/20/2015.
 */
// model class in MVC
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    /////// below is all about singleton class requirements //////
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    // singleton class to make sure that there is only one list of crimes is available
    // across all Activities and Frames
    // note the ***private*** constructor which prevents others from creating objects of this class
    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();

        // meant for UNIT TESTING & MOCKING
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(c);
        }
    }
    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext()); // ApplicationContext is global to the app
            // used by the app-wide singleton classes
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }
    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
}
