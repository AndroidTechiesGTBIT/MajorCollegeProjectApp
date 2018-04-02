package com.example.androidtechies.majorproject.ListProjects;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.androidtechies.majorproject.Data.DataSource;
import com.example.androidtechies.majorproject.Data.IDataSource;
import com.example.androidtechies.majorproject.Data.Project;

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
                view.showToastIfNoDataAvailable();
            }
        });
        return null;
    }

    @Override
    public void startDetailedActivity(int pos) {
        view.startDetailedActivity(pos);
    }
}
