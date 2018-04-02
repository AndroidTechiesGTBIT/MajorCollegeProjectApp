package com.example.androidtechies.majorproject.Data;

import android.support.annotation.NonNull;

import com.example.androidtechies.majorproject.Data.db.Project;
import com.example.androidtechies.majorproject.Data.pref.IPrefHelper;

import java.util.List;

public interface IDataSource extends IPrefHelper{

    interface LoadDataCallBack {
        void onBranchDataLoaded(List<Project> projects);
        void onDataNotAvailable();
    }

    void getBranchProjects(@NonNull String branch, @NonNull LoadDataCallBack callBack);

    void saveProject(@NonNull List<Project> projects);

    void getCountProjects(@NonNull CountProjectsCallback countProjects);

    void nukeTable();

    interface CountProjectsCallback {
        void onCountReturned(int countValue);
    }
}
