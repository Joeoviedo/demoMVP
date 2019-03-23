package com.example.mapsalud.presentation.splashscreen.view.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mapsalud.R;
import com.example.mapsalud.presentation.main.view.activities.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = MainActivity.newIntent(SplashScreenActivity.this);
                startActivity(intent);
            }
        }, getResources().getInteger(R.integer.splashscreen_duration));
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
