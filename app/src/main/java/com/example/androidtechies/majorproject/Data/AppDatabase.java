package com.example.androidtechies.majorproject.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


@Database(entities = {Project.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ProjectDao projectDao();

    private static final Object sLock = new Object();


    public static AppDatabase getAppDatabase(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class, "user-database")
                                .fallbackToDestructiveMigration()
                                .build();
            }
            return INSTANCE;
        }

    }



    public static void destroyInstance() {
        INSTANCE = null;
    }

}
