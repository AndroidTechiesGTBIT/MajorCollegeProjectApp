package com.example.androidtechies.majorproject.BranchPage;

import com.example.androidtechies.majorproject.Data.DataManager;
import com.example.androidtechies.majorproject.Data.ProjectModel;

import java.util.List;

public class HomePresenter implements HomeContract.IHomePresenter{

    private final DataManager manager;
    private HomeContract.IHomeView view;

    public HomePresenter(HomeContract.IHomeView view, DataManager dataSource) {
        this.view = view;
        this.manager =dataSource;
    }

    /*
    Called on any of the four button clicks , receives branch value & passes it to view function
     */
    @Override
    public void openNewActivity(String branchValue) {
        view.showNewActivity(branchValue);

    }

    /*
    Inserts value into sqlite database, interacts with Datamanger only
     */
    @Override
    public void insertData(List<ProjectModel> projects) {
        manager.saveProject(projects);
    }

    /*
    Currently, only logs , not implemented yet
     */
    @Override
    public void deleteAllData() {
        manager.nukeTable();
    }
}
