package com.example.androidtechies.majorproject.Utils;

import android.content.Context;

import com.example.androidtechies.majorproject.Data.db.AppDatabase;
import com.example.androidtechies.majorproject.Data.DataSource;
import com.example.androidtechies.majorproject.Data.pref.PrefHelper;

import static com.example.androidtechies.majorproject.Data.DataSource.getInstance;

public class InjectionClass {

    public static DataSource provideDataSource(Context context) {
        AppDatabase database = AppDatabase.getAppDatabase(context);
        return getInstance(new AppExecutors(),database.projectDao(),new PrefHelper(context,"pref_file"));
    }
}
