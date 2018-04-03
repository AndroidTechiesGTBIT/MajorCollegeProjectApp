package com.example.androidtechies.majorproject.Data;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;


import com.example.androidtechies.majorproject.Data.db.DbSource;
import com.example.androidtechies.majorproject.Data.pref.IPrefHelper;
import com.example.androidtechies.majorproject.Utils.LogAndToastUtil;

import java.util.List;

public class DataManager implements IDataManager {
    //tag by class name
    private static final String TAG = DataManager.class.getName();


    private static volatile DataManager INSTANCE;

    private DbSource dbSource;
    private IPrefHelper prefHelper;

    // Prevent direct instantiation.
    private DataManager(DbSource dbSource, IPrefHelper prefHelper) {
        this.dbSource = dbSource;
        this.prefHelper = prefHelper;
    }


    public static DataManager getInstance(@NonNull Context context, @NonNull IPrefHelper prefHelper) {
        if (INSTANCE == null) {
            synchronized (DataManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataManager(DbSource.getInstance(context), prefHelper);
                }
            }
        }
        return INSTANCE;
    }



    /*
       preference Manager
     */

    @Override
    public boolean checkFirstTime() {
        return prefHelper.checkFirstTime();
    }

    @Override
    public void setFirstTime(boolean value) {
        prefHelper.setFirstTime(value);
    }


    /*
       SQLite database manager
     */

    @Override
    public Cursor getBranchProjects(@NonNull String branch) {
        return dbSource.getBranchProjects(branch);
    }

    @Override
    public void saveProject(@NonNull List<ProjectModel> projects) {
        dbSource.saveProject(projects);
    }

    @Override
    public long getCountProjects() {

        return dbSource.getCountProjects();
    }

    @Override
    public void nukeTable() {
        LogAndToastUtil.Logging("nuke table function called!");
    }
}
