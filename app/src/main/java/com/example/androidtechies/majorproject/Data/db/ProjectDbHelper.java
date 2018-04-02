package com.example.androidtechies.majorproject.Data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidtechies.majorproject.Data.db.ProjectContract.ProjectEntry;
import com.example.androidtechies.majorproject.Utils.LogAndToastUtil;

public class ProjectDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "project-database";
    private static final int DATABASE_VERSION = 1;

    public ProjectDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_DATABASE_QUERY = "CREATE TABLE " + ProjectEntry.TABLE_NAME + "("
                + ProjectEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProjectEntry.COLUMN_BRANCH + " TEXT NOT NULL, "
                + ProjectEntry.COLUMN_PROJECT_TITLE + " TEXT NOT NULL, "
                + ProjectEntry.COLUMN_PROJECT_INTRO + " TEXT, "
                + ProjectEntry.COLUMN_TECH_USED + " TEXT, "
                + ProjectEntry.COLUMN_MODULES_USED + " TEXT"
                + ");";
        LogAndToastUtil.Logging(CREATE_DATABASE_QUERY);
        db.execSQL(CREATE_DATABASE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ProjectEntry.TABLE_NAME);
        onCreate(db);
    }
}
