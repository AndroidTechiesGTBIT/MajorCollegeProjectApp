package com.example.androidtechies.majorproject.Utils;

import android.content.Context;

import com.example.androidtechies.majorproject.Data.DataManager;
import com.example.androidtechies.majorproject.Data.pref.PrefHelper;

public class InjectionClass {

    public static DataManager provideDataSource(Context context) {
        return DataManager.getInstance(context, new PrefHelper(context,"pref_file" ));
    }
}
