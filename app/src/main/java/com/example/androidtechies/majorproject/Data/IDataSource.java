package com.example.androidtechies.majorproject.Data;

import android.support.annotation.NonNull;

import java.util.List;

public interface IDataSource {

    interface LoadDataCallBack {
        void onBranchDataLoaded(List<Project> projects);
        void onDataNotAvailable();
    }

    void getBranchProjects(@NonNull String branch, @NonNull LoadDataCallBack callBack);

    void saveProject(@NonNull List<Project> projects);

    void getCountProjects(@NonNull CountProjectsCallback countProjects);

    interface CountProjectsCallback {
        void onCountReturned(int countValue);
    }
}
