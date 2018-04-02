package com.example.androidtechies.majorproject.BranchPage;


public interface HomeContract {

    interface IHomePresenter {
        void openNewActivity(String branch);
    }

    interface IHomeView {
        void showNewActivity(String branch);
    }
}
