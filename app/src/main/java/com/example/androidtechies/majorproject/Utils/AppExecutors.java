package com.example.androidtechies.majorproject.Utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors implements Executor {

    private final Executor mDiskIO;
    @Override
    public void execute(@NonNull Runnable command) {
        mDiskIO.execute(command);

    }

    public AppExecutors() {
        mDiskIO = Executors.newSingleThreadExecutor();
    }

    public Executor diskIO() {
        return mDiskIO;
    }
}
