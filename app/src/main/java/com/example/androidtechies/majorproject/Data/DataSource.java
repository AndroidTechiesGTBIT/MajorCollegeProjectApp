package com.example.androidtechies.majorproject.Data;

import android.support.annotation.NonNull;
import android.util.Log;


import com.example.androidtechies.majorproject.Data.db.Project;
import com.example.androidtechies.majorproject.Data.db.ProjectDao;
import com.example.androidtechies.majorproject.Data.pref.IPrefHelper;
import com.example.androidtechies.majorproject.Utils.AppExecutors;

import java.util.List;

public class DataSource implements IDataSource {
    //tag by class name
    private static final String TAG = DataSource.class.getName();


    private static volatile DataSource INSTANCE;

    private ProjectDao projectDao;

    private AppExecutors appExecutors;
    private IPrefHelper prefHelper;

    // Prevent direct instantiation.
    private DataSource(@NonNull AppExecutors appExecutors,
                       @NonNull ProjectDao projectDao, IPrefHelper prefHelper) {
        this.appExecutors = appExecutors;
        this.projectDao = projectDao;
        this.prefHelper = prefHelper;
    }


    public static DataSource getInstance(@NonNull AppExecutors appExecutors,
                                         @NonNull ProjectDao dao, @NonNull IPrefHelper prefHelper) {
        if (INSTANCE == null) {
            synchronized (DataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataSource(appExecutors, dao, prefHelper);
                }
            }
        }
        return INSTANCE;
    }



    @Override
    public void getBranchProjects(@NonNull final String branch, @NonNull final LoadDataCallBack callBack) {

        Runnable getRunnable = new Runnable() {
            @Override
            public void run() {
                final List<Project> projects = projectDao.getBranchAllData(branch);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (projects.isEmpty()) {
                            Log.d("callback", "empty callback");
                            callBack.onDataNotAvailable();
                        } else {
                            callBack.onBranchDataLoaded(projects);
                        }

                    }
                });
            }
        };

        appExecutors.diskIO().execute(getRunnable);
    }

    @Override
    public void saveProject(@NonNull final List<Project> projects) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                projectDao.insertAll(projects);
            }
        };
        appExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void getCountProjects(@NonNull final CountProjectsCallback callback) {
        Runnable countRunnable = new Runnable() {
            @Override
            public void run() {
                final int count = projectDao.countProjects();
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onCountReturned(count);
                    }
                });
            }
        };
        appExecutors.diskIO().execute(countRunnable);
    }

    @Override
    public void nukeTable() {
        Runnable deleteTableData = new Runnable() {
            @Override
            public void run() {
                projectDao.nukeTable();
            }
        };
        appExecutors.diskIO().execute(deleteTableData);
    }

    @Override
    public boolean checkFirstTime() {
        return prefHelper.checkFirstTime();
    }

    @Override
    public void setFirstTime(boolean value) {
        prefHelper.setFirstTime(value);
    }
}
