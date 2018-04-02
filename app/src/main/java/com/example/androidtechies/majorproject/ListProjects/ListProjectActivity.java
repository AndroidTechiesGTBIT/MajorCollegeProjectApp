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
import com.example.androidtechies.majorproject.Data.Project;
import com.example.androidtechies.majorproject.DescriptionActivity;
import com.example.androidtechies.majorproject.InformationModel;
import com.example.androidtechies.majorproject.R;
import com.example.androidtechies.majorproject.ListProjects.ListActivityContract.IListActivityView;
import com.example.androidtechies.majorproject.Utils.InjectionClass;

import java.util.ArrayList;
import java.util.List;

public class ListProjectActivity extends AppCompatActivity implements IListActivityView{
    ArrayList<InformationModel> informationModelArrayList;
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    ListActivityPresenter listPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);


        Intent intent = getIntent();
        String branch = intent.getStringExtra(HomeScreenActivity.HomeScreenTag);
        Log.d(HomeScreenActivity.HomeScreenTag, branch);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listPresenter = new ListActivityPresenter(this, InjectionClass.provideDataSource(this));
        listPresenter.countProjects();


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
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void createAdapterAndSetData(final List<Project> projects) {
        listAdapter = new ListAdapter(projects, this, new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                listPresenter.startDetailedActivity(projects.get(position));
                Toast.makeText(ListProjectActivity.this,"click on "+(position+1)+ "th row", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(listAdapter);
    }


    @Override
    public void startDetailedActivity(Project project) {
        Intent intent = new Intent(ListProjectActivity.this, DescriptionActivity.class);
        intent.putExtra("Information",project);
        startActivity(intent);
    }
}
