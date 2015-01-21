package com.example.rreddy.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rreddy on 1/20/2015.
 */
// model class in MVC
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    boolean mSolved = false;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Crime()
    {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
    @Override
    public String toString() { return mTitle; }

}
