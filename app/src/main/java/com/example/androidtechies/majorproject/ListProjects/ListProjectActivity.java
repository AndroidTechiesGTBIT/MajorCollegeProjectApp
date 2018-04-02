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
        listPresenter.getBranchSpecificList(branch);





    }

//    private ArrayList<InformationModel> createFakeData(int value) {
//        ArrayList<InformationModel> arrayList = new ArrayList<>();
//        int length = getResources().getStringArray(R.array.project_title_it).length;
//        InformationModel model;
//        for(int i=0 ; i<length; i++) {
//            model = new InformationModel(
//                    getResources().getStringArray(R.array.project_title_it)[i],
//                    getResources().getStringArray(R.array.project_introduction_it)[i],
//                    getResources().getStringArray(R.array.project_technology_used_it)[i]
//                    );
//            arrayList.add(model);
//        }
//        return arrayList;
//    }

    @Override
    public void setRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void showToastIfNoDataAvailable() {
        Toast.makeText(this,"No Data Available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createAdapterAndSetData(List<Project> projects) {
        listAdapter = new ListAdapter(informationModelArrayList, this, new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                listPresenter.startDetailedActivity(position);
            }
        });
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void startDetailedActivity(int pos) {
        Intent intent = new Intent(ListProjectActivity.this, DescriptionActivity.class);
        intent.putExtra("Information",informationModelArrayList.get(pos));
        startActivity(intent);
    }
}
