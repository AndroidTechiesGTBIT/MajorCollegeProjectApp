package com.example.androidtechies.majorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    public static final String HomeScreenTag = "HomeScreen";
    public static final Integer cseValue = 0;
    public static final Integer it = 0;
    public static final Integer ece = 0;
    public static final Integer eee = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final Button cse = (Button) findViewById(R.id.cseTag);
        Button ece = (Button) findViewById(R.id.eceTag);
        Button it = (Button) findViewById(R.id.itTag);
        Button eee = (Button) findViewById(R.id.eeeTag);
        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cseIntent = new Intent(HomeScreen.this, ListPage.class);
                cseIntent.putExtra(HomeScreenTag, cseValue);
                startActivity(cseIntent);

            }
        });
//        ece.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent ece = new Intent(HomeScreen.this, ECEHomeScreen.class);
//                startActivity(ece);
//
//            }
//        });
//        it.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(HomeScreen.this, ITHomeScreen.class);
//                startActivity(it);
//
//            }
//        });
//        eee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent eee = new Intent(HomeScreen.this, EEEHomeScreen.class);
//                startActivity(eee);
//
//            }
//        });
    }
    }

