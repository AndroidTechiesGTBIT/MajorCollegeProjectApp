package com.example.androidtechies.majorproject.ListProjects;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.androidtechies.majorproject.Data.DataSource;
import com.example.androidtechies.majorproject.Data.IDataSource;
import com.example.androidtechies.majorproject.Data.db.Project;

import java.util.List;

public class ListActivityPresenter implements ListActivityContract.IListActivityPresenter {

    private final ListActivityContract.IListActivityView view;
    private DataSource dataSource;

    public ListActivityPresenter(@NonNull ListActivityContract.IListActivityView view,@NonNull DataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        view.setRecyclerView();
    }

    @Override
    public List<Project> getBranchSpecificList(String branch) {

        dataSource.getBranchProjects(branch, new IDataSource.LoadDataCallBack() {
            @Override
            public void onBranchDataLoaded(List<Project> projects) {
                view.createAdapterAndSetData(projects);
            }

            @Override
            public void onDataNotAvailable() {
                view.showToast("Data not available");
            }
        });
        return null;
    }

    @Override
    public void startDetailedActivity(Project project) {
        view.startDetailedActivity(project);
    }

    @Override
    public void countProjects() {
        dataSource.getCountProjects(new IDataSource.CountProjectsCallback() {
            @Override
            public void onCountReturned(int countValue) {
                Log.d("myTag", "count value is "+countValue);
                if (countValue<=0) {
                    view.showToast("data not inserted properly");
                }
                else {
                    view.showToast("successful data insertion "+ countValue);
                }
            }
        });
    }
}
