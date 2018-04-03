package com.example.androidtechies.majorproject.ListProjects;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.androidtechies.majorproject.Data.DataManager;
import com.example.androidtechies.majorproject.Data.ProjectModel;
import com.example.androidtechies.majorproject.Data.db.ProjectContract;
import com.example.androidtechies.majorproject.Utils.LogAndToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ListActivityPresenter implements ListActivityContract.IListActivityPresenter {

    private final ListActivityContract.IListActivityView view;
    private DataManager manager;

    public ListActivityPresenter(@NonNull ListActivityContract.IListActivityView view,@NonNull DataManager dataSource) {
        this.view = view;
        this.manager = dataSource;

        view.setRecyclerView();
    }

    @Override
    public void getBranchSpecificList(String branch) {

        Cursor cursor = manager.getBranchProjects(branch);
        List<ProjectModel> list = new ArrayList<>();
        ProjectModel model;
        if(cursor!=null) {
            try {
                while (cursor.moveToNext()) {
                    model = new ProjectModel(
                      branch, cursor.getString(cursor.getColumnIndex(ProjectContract.ProjectEntry.COLUMN_PROJECT_TITLE)),
                            cursor.getString(cursor.getColumnIndex(ProjectContract.ProjectEntry.COLUMN_PROJECT_INTRO)),
                            cursor.getString(cursor.getColumnIndex(ProjectContract.ProjectEntry.COLUMN_TECH_USED)),
                            cursor.getString(cursor.getColumnIndex(ProjectContract.ProjectEntry.COLUMN_MODULES_USED))
                    );
                    list.add(model);
                }
            } finally {
                cursor.close();
                LogAndToastUtil.Logging("cursor value changed to list- list presenter");
            }
            view.createAdapterAndSetData(list);
        }
       else {
            LogAndToastUtil.Logging("no data available");
        }
    }

    @Override
    public void startDetailedActivity(ProjectModel project) {
        view.startDetailedActivity(project);
    }

    @Override
    public void countProjects() {
        manager.getCountProjects();
    }
}
