package com.example.androidtechies.majorproject.ListProjects;

import com.example.androidtechies.majorproject.Data.Project;

import java.util.List;

public interface ListActivityContract {
    interface IListActivityView {
        void setRecyclerView();
        void showToastIfNoDataAvailable();
        void createAdapterAndSetData(List<Project> projects);
        void startDetailedActivity(int pos);
    }

    interface IListActivityPresenter {

        List<Project> getBranchSpecificList(String branch);
        void startDetailedActivity(int pos);

    }
}

