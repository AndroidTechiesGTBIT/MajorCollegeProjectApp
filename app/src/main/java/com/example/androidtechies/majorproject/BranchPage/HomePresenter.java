package com.example.androidtechies.majorproject.BranchPage;

import com.example.androidtechies.majorproject.Data.DataSource;
import com.example.androidtechies.majorproject.Data.db.Project;

import java.util.List;

public class HomePresenter implements HomeContract.IHomePresenter{

    private final DataSource dataSource;
    private HomeContract.IHomeView view;

    public HomePresenter(HomeContract.IHomeView view, DataSource dataSource) {
        this.view = view;
        this.dataSource =dataSource;
    }

    @Override
    public void openNewActivity(String branchValue) {
        view.showNewActivity(branchValue);

    }

    @Override
    public void insertData(List<Project> projects) {
        dataSource.saveProject(projects);
    }

    @Override
    public void deleteAllData() {
        dataSource.nukeTable();
    }
}
