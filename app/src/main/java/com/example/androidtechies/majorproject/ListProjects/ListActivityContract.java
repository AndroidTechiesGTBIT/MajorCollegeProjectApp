package com.example.androidtechies.majorproject.ListProjects;

import com.example.androidtechies.majorproject.Data.Project;

import java.util.List;

public interface ListActivityContract {
    interface IListActivityView {
        void setRecyclerView();
        void showToast(String textMsg);
        void createAdapterAndSetData(List<Project> projects);
        void startDetailedActivity(Project project);
    }

    interface IListActivityPresenter {

        List<Project> getBranchSpecificList(String branch);
        void startDetailedActivity(Project project);
        void countProjects();

    }
}

