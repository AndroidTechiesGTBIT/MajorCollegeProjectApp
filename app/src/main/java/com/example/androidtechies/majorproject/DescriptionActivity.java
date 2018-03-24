package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        Intent intent = getIntent();
        InformationModel model = intent.getParcelableExtra("Information");

        Log.d("description", model.getTitleOfProject());

    }
}
