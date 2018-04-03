package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androidtechies.majorproject.Data.ProjectModel;
import com.example.androidtechies.majorproject.Utils.LogAndToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionActivity extends AppCompatActivity {

    @BindView(R.id.intro_brief)
    TextView introDescription;
    @BindView(R.id.tech_brief)
    TextView techDescription;
    @BindView(R.id.modules_used)
    TextView modulesUsed;
    @BindView(R.id.collapsingtoolbar)
    CollapsingToolbarLayout cToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ProjectModel detail = intent.getParcelableExtra("Information");
        String title = detail.getTitleOfProject();
        String intro = detail.getIntroOfProject();
        String tech = detail.getTechnologyUsed();
        String module = detail.getModulesOfProject();

        LogAndToastUtil.Logging("1 " + title + "\n2 " + intro + "\n3 " + tech + "\n4 " + module);
        cToolBar.setTitle(title);
        introDescription.setText(intro);
        techDescription.setText(tech);
        modulesUsed.setText(module);
//        introDescription.setText(intro);
//        techDescription.setText(tech);
//        cToolBar.setTitle(title);
    }
}
