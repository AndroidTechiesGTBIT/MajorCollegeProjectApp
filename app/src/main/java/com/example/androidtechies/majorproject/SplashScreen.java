package com.example.androidtechies.majorproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import com.example.androidtechies.majorproject.BranchPage.HomeScreenActivity;

public class SplashScreen extends AppCompatActivity {
private TextView textView;
private ImageView imageView;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.projectName);
        imageView=(ImageView) findViewById(R.id.splashIcon);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        textView.startAnimation(myanim);
        imageView.startAnimation(myanim);
        final Intent branch = new Intent(this,HomeScreenActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(branch);
                    finish();
                }
            }
        };
        timer.start();
    }

}
