package com.example.androidtechies.majorproject.BranchPage;

public class HomePresenter implements HomeContract.IHomePresenter{

    private HomeContract.IHomeView view;

    public HomePresenter(HomeContract.IHomeView view) {
        this.view = view;
    }

    @Override
    public void openNewActivity(String branchValue) {
        view.showNewActivity(branchValue);

    }
}
