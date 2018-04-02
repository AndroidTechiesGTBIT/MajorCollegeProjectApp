package com.example.androidtechies.majorproject.BranchPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtechies.majorproject.ListProjects.ListProjectActivity;
import com.example.androidtechies.majorproject.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);
        presenter = new HomePresenter(this);
        //setting listeners on all buttons
        cseButton.setOnClickListener(this);
        itButton.setOnClickListener(this);
        eceButton.setOnClickListener(this);
        eeeButton.setOnClickListener(this);

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

    //Todo ask for any other way of handling multiple buttons openin same activity with some passing value
    @Override
    public void showNewActivity(String branchValue) {
        Intent intent = new Intent(this, ListProjectActivity.class);
        intent.putExtra(HomeScreenTag, branchValue);
        startActivity(intent);
    }



}

