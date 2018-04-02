package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androidtechies.majorproject.Data.db.Project;

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
        Project detail = intent.getParcelableExtra("Information");
        String title = detail.getTitleOfProject();
        String intro = detail.getIntroOfProject();
        String tech = detail.getTechnologyUsed();
        String module = detail.getModulesOfProject();
        Log.d("Information", "1 "+title+ "\n2 "+intro+ "\n3 "+tech+ "\n4 "+module);
//        introDescription.setText(intro);
//        techDescription.setText(tech);
//        cToolBar.setTitle(title);
    }
}
