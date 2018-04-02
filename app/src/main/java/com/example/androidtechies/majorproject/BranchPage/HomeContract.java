package com.example.androidtechies.majorproject.BranchPage;


import com.example.androidtechies.majorproject.Data.Project;

import java.util.List;

public interface HomeContract {

    interface IHomePresenter {
        void openNewActivity(String branch);
        void insertData(List<Project> projects);
    }

    interface IHomeView {
        void showNewActivity(String branch);
    }
}
