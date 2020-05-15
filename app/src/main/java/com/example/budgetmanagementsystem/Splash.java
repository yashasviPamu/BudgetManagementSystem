package com.example.budgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends Activity {
    long Delay = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Timer RunSplash = new Timer();
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent myIntent = new Intent(Splash.this,MainActivity.class);
                startActivity(myIntent);
            }
        };
        RunSplash.schedule(ShowSplash, Delay);
    }
}
