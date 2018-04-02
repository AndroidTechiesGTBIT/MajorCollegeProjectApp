package com.example.androidtechies.majorproject.BranchPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtechies.majorproject.Data.Project;
import com.example.androidtechies.majorproject.ListProjects.ListProjectActivity;
import com.example.androidtechies.majorproject.R;
import com.example.androidtechies.majorproject.Utils.InjectionClass;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener,HomeContract.IHomeView{
    public static final String HomeScreenTag = "HomeScreenActivity";

    @BindView(R.id.cseTag)
    Button cseButton;
    @BindView(R.id.itTag)
    Button itButton;
    @BindView(R.id.eceTag)
    Button eceButton;
    @BindView(R.id.eeeTag)
    Button eeeButton;

    HomePresenter presenter;

    //Todo Check first installation of application & then only insert data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);
        presenter = new HomePresenter(this , InjectionClass.provideDataSource(this));
        //setting listeners on all buttons
        cseButton.setOnClickListener(this);
        itButton.setOnClickListener(this);
        eceButton.setOnClickListener(this);
        eeeButton.setOnClickListener(this);
        createProjectArrayList();
    }


    //Todo replace team name with modules
    private void createProjectArrayList() {
        List<Project> arrayList = new ArrayList<>();
        int lengthIt = getResources().getStringArray(R.array.project_titles_it).length;
        Project model;
        for(int i=0 ; i<lengthIt; i++) {
            model = new Project(
                    getResources().getString(R.string.it),
                    getResources().getStringArray(R.array.project_titles_it)[i],
                    getResources().getStringArray(R.array.project_introductions_it)[i],
                    getResources().getStringArray(R.array.project_technology_used_it)[i],
                    getResources().getStringArray(R.array.modules_of_project)[i]
                    );
            arrayList.add(model);
        }
        presenter.insertData(arrayList);
    }

//    private void populateDatabase() {
//        DataSource.populateAsync(AppDatabase.getAppDatabase(this));
//    }

    //Todo add more button  clicks when data is available

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cseTag : break;
            case R.id.itTag :  presenter.openNewActivity(getString(R.string.it));
                               break;
            case R.id.eceTag : break;
            case R.id.eeeTag : break;
        }
    }


    @Override
    public void showNewActivity(String branchValue) {
        Intent intent = new Intent(this, ListProjectActivity.class);
        intent.putExtra(HomeScreenTag, branchValue);
        startActivity(intent);
    }

}

