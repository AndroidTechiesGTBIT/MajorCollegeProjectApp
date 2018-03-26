package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionActivity extends AppCompatActivity {

    @BindView(R.id.intro_brief)
    TextView introDescription;
    @BindView(R.id.tech_brief)
    TextView techDescription;
    @BindView(R.id.collapsingtoolbar)
    CollapsingToolbarLayout cToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        InformationModel model = intent.getParcelableExtra("Information");
        String title = model.getTitleOfProject();
        String intro = model.getIntroProject();
        String tech = model.getTechnologyUsed();
        Log.d("Information", title+ " 2 "+intro+ " 3 "+tech);
        introDescription.setText(intro);
        techDescription.setText(tech);
        cToolBar.setTitle(title);
    }
}
