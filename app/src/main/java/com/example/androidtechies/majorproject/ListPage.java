package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListPage extends AppCompatActivity {
    ArrayList<InformationModel> informationModelArrayList;
    RecyclerView recyclerView;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);
        Intent intent = getIntent();
        Integer value = intent.getIntExtra(HomeScreen.HomeScreenTag,0);
        informationModelArrayList = new ArrayList<>();
        informationModelArrayList = createFakeData(value);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
      //  listAdapter = new ListAdapter(informationModelArrayList, this);

        listAdapter = new ListAdapter(informationModelArrayList, this, new ListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(ListPage.this, DescriptionActivity.class);
                intent.putExtra("Information",informationModelArrayList.get(position));
                startActivity(intent);

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);
    }

    // Todo check value and apply switch case

    private ArrayList<InformationModel> createFakeData(int value) {
        ArrayList<InformationModel> arrayList = new ArrayList<>();
        int length = getResources().getStringArray(R.array.project_title_it).length;
        InformationModel model;
        for(int i=0 ; i<length; i++) {
            model = new InformationModel(
                    getResources().getStringArray(R.array.project_title_it)[i],
                    getResources().getStringArray(R.array.project_introduction_it)[i],
                    getResources().getStringArray(R.array.project_technology_used_it)[i]
                    );
            arrayList.add(model);
        }
        return arrayList;
    }
}
