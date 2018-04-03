package com.example.androidtechies.majorproject.ListProjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidtechies.majorproject.BranchPage.HomeScreenActivity;
import com.example.androidtechies.majorproject.Data.ProjectModel;
import com.example.androidtechies.majorproject.DescriptionActivity;
import com.example.androidtechies.majorproject.R;
import com.example.androidtechies.majorproject.ListProjects.ListActivityContract.IListActivityView;
import com.example.androidtechies.majorproject.Utils.InjectionClass;
import com.example.androidtechies.majorproject.Utils.LogAndToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ListProjectActivity extends AppCompatActivity implements IListActivityView {
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    ListActivityPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);


        //receives branch name from intent
        Intent intent = getIntent();
        String branch = intent.getStringExtra(HomeScreenActivity.HomeScreenTag);
        LogAndToastUtil.Logging(branch);

        recyclerView = findViewById(R.id.recyclerView);
        listPresenter = new ListActivityPresenter(this, InjectionClass.provideDataSource(this));
        listPresenter.getBranchSpecificList(branch);
    }


    @Override
    public void setRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void createAdapterAndSetData(final List<ProjectModel> projects) {
        listAdapter = new ListAdapter(projects, this, new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                listPresenter.startDetailedActivity(projects.get(position));
            }
        });
        recyclerView.setAdapter(listAdapter);
    }


    @Override
    public void startDetailedActivity(ProjectModel project) {
        Intent intent = new Intent(ListProjectActivity.this, DescriptionActivity.class);
        intent.putExtra("Information", project);
        startActivity(intent);
    }
}
