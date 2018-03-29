package com.example.androidtechies.majorproject.RoomSample;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();


    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Project addProject (final AppDatabase db, Project project) {
        db.projectDao().insertAll(project);
        return project;
    }

    private static void populateWithTestData(AppDatabase db) {

        Project project = new Project();
        project.setTitleOfProject("Hinton");
        project.setIntroOfProject("Hinton is a fake news generator (video) platform that aims to create\n" +
                "    awareness among the society ");
        project.setModulesOfProject("news");
        project.setProjectBranch("IT");
        project.setTechnologyUsed("Machine learning");
        addProject(db, project);

        List<Project> projectsList = db.projectDao().getAll();

        int count = db.projectDao().countProjects();
       // Log.d(DatabaseInitializer.TAG,);
        Log.d(DatabaseInitializer.TAG, "Branch name: " + projectsList.get(0).getProjectBranch()+ "\nNumber of rows: "+count);
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
