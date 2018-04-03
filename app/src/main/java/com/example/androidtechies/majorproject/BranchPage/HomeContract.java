package com.example.androidtechies.majorproject.BranchPage;


import com.example.androidtechies.majorproject.Data.ProjectModel;

import java.util.List;

public interface HomeContract {

    interface IHomePresenter {
        void openNewActivity(String branch);
        void insertData(List<ProjectModel> projects);
        void deleteAllData();
    }

    interface IHomeView {
        void showNewActivity(String branch);
    }
}
