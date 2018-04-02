package com.example.androidtechies.majorproject.BranchPage;

import com.example.androidtechies.majorproject.Data.DatabaseInitializer;

public class HomePresenter implements HomeContract.IHomePresenter{

    private HomeContract.IHomeView view;

    public HomePresenter(HomeContract.IHomeView view) {
        this.view = view;
    }

    @Override
    public void openNewActivity(int branchValue) {
        view.showNewActivity(branchValue);

    }
}
