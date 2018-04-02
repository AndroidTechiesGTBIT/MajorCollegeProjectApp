package com.example.androidtechies.majorproject.Data;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;


import com.example.androidtechies.majorproject.Utils.AppExecutors;

import java.util.List;

public class DataSource implements IDataSource {
    //tag by class name
    private static final String TAG = DataSource.class.getName();


    private static volatile DataSource INSTANCE;

    private ProjectDao projectDao;

    private AppExecutors appExecutors;

    // Prevent direct instantiation.
    private DataSource(@NonNull AppExecutors appExecutors,
                       @NonNull ProjectDao projectDao) {
        this.appExecutors = appExecutors;
        this.projectDao = projectDao;
    }


    public static DataSource getInstance(@NonNull AppExecutors appExecutors,
                                         @NonNull ProjectDao dao) {
        if (INSTANCE == null) {
            synchronized (DataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataSource(appExecutors, dao);
                }
            }
        }
        return INSTANCE;
    }



    @Override
    public void getBranchProjects(@NonNull final String branch, @NonNull final LoadDataCallBack callBack) {

        Runnable getRunnable = new Runnable() {
            @Override
            public void run() {
                final List<Project> projects = projectDao.getBranchAllData(branch);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (projects.isEmpty()) {
                            Log.d("callback", "empty callback");
                            callBack.onDataNotAvailable();
                        } else {
                            callBack.onBranchDataLoaded(projects);
                        }

                    }
                });
            }
        };

        appExecutors.diskIO().execute(getRunnable);
    }

    @Override
    public void saveProject(@NonNull final List<Project> projects) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                projectDao.insertAll(projects);
            }
        };
        appExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void getCountProjects(@NonNull final CountProjectsCallback callback) {
        Runnable countRunnable = new Runnable() {
            @Override
            public void run() {
                final int count = projectDao.countProjects();
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onCountReturned(count);
                    }
                });
            }
        };
        appExecutors.diskIO().execute(countRunnable);
    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final AppDatabase mDb;
//
//        PopulateDbAsync(AppDatabase db) {
//            mDb = db;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            populateWithTestData(mDb);
//            return null;
//        }
//
//    }
//
//    private static class GetProjectsAsync extends AsyncTask<String, Void, List<Project>> {
//
//        private final AppDatabase database;
//
//        public GetProjectsAsync(AppDatabase database) {
//            this.database = database;
//        }
//
//        @Override
//        protected List<Project> doInBackground(String... strings) {
//            String branchName = strings[0];
//            List<Project> projects = database.projectDao().getBranchAllData(branchName);
//
//            return projects;
//        }
//
//        @Override
//        protected void onPostExecute(List<Project> projects) {
//            super.onPostExecute(projects);
//
//        }
//    }
    //creates & executes populate async-task
//    public static void populateAsync(@NonNull final AppDatabase db) {
//        PopulateDbAsync task = new PopulateDbAsync(db);
//        task.execute();
//
//    }
//
//    private static Project addProject (final AppDatabase db, Project project) {
//        db.projectDao().insertAll(project);
//        return project;
//    }

//    private static void populateWithTestData(AppDatabase db) {
//
//        Project project = new Project();
//        project.setTitleOfProject("Hinton");
//        project.setIntroOfProject("Hinton is a fake news generator (video) platform that aims to create\n" +
//                "    awareness among the society ");
//        project.setModulesOfProject("news");
//        project.setProjectBranch("IT");
//        project.setTechnologyUsed("Machine learning");
//        addProject(db, project);
//
//
//        int count = db.projectDao().countProjects();
//    }

}
