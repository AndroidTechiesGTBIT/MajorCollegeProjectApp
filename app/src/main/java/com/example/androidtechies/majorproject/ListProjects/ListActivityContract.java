package com.example.androidtechies.majorproject.ListProjects;

import com.example.androidtechies.majorproject.Data.ProjectModel;

import java.util.List;

public interface ListActivityContract {
    interface IListActivityView {
        void setRecyclerView();
        void showToast(String textMsg);
        void createAdapterAndSetData(List<ProjectModel> projects);
        void startDetailedActivity(ProjectModel project);
    }

    interface IListActivityPresenter {

        void getBranchSpecificList(String branch);
        void startDetailedActivity(ProjectModel project);
        void countProjects();

    }
}

