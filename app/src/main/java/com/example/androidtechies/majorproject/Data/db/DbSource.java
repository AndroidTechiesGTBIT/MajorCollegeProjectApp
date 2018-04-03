package com.example.androidtechies.majorproject.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.androidtechies.majorproject.Data.ProjectModel;
import com.example.androidtechies.majorproject.Data.db.ProjectContract.ProjectEntry;

import java.util.List;

public class DbSource implements IDbSource {

    private static DbSource INSTANCE;
    private static final Object sLock = new Object();
    public static ProjectDbHelper dbHelper;

    public DbSource(Context context) {
        dbHelper = new ProjectDbHelper(context);
    }

    public static DbSource getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        new DbSource(context);
            }
            return INSTANCE;
        }
    }

    @Override
    public Cursor getBranchProjects(@NonNull String branch) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = new String[]{ProjectEntry.COLUMN_PROJECT_TITLE, ProjectEntry.COLUMN_PROJECT_INTRO,
                ProjectEntry.COLUMN_TECH_USED, ProjectEntry.COLUMN_MODULES_USED};
        String whereClause = ProjectEntry.COLUMN_BRANCH + " = ?";
        String[] whereArgs = new String[]{branch};

        return db.query(ProjectEntry.TABLE_NAME, columns, whereClause, whereArgs,
                null, null, ProjectEntry._ID);
    }

    @Override
    public void saveProject(@NonNull List<ProjectModel> projects) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.beginTransaction();
        try{
            for (ProjectModel project: projects){
                values.put(ProjectEntry.COLUMN_BRANCH,project.getProjectBranch());
                values.put(ProjectEntry.COLUMN_PROJECT_TITLE,project.getTitleOfProject());
                values.put(ProjectEntry.COLUMN_PROJECT_INTRO,project.getIntroOfProject());
                values.put(ProjectEntry.COLUMN_TECH_USED,project.getTechnologyUsed());
                values.put(ProjectEntry.COLUMN_MODULES_USED,project.getModulesOfProject());
                db.insert(ProjectEntry.TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }

    }

    @Override
    public long getCountProjects() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, ProjectEntry.TABLE_NAME);
        return count;
    }

    @Override
    public void nukeTable() {

    }
}
