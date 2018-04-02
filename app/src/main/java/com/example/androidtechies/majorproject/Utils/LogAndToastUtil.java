package com.example.androidtechies.majorproject.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class LogAndToastUtil {
    private static final String TAG = "myTag";

    public static void Logging(String msg) {
        Log.d(TAG, msg);
    }

    public static void Toasting(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
