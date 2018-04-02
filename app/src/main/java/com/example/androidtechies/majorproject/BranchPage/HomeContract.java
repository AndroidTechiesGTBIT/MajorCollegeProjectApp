package com.example.androidtechies.majorproject.BranchPage;


public interface HomeContract {

    interface IHomePresenter {
        void openNewActivity(int i);
    }

    interface IHomeView {
        void showNewActivity(int i);
    }
}
