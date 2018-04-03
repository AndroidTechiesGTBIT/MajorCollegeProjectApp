package com.example.androidtechies.majorproject.Data.db;

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.example.androidtechies.majorproject.Data.ProjectModel;

import java.util.List;

public interface IDbSource {

    interface LoadDataCallBack {
        void onBranchDataLoaded(Cursor cursor);
        void onDataNotAvailable();
    }
    Cursor getBranchProjects(@NonNull String branch);

    void saveProject(@NonNull List<ProjectModel> projects);

    long getCountProjects();

    void nukeTable();

}
