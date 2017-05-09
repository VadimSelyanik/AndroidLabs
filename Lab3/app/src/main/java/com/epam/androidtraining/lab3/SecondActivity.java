package com.epam.androidtraining.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    final String avtivityName = "Main Activity 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(avtivityName, "OnCreate");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.start_third_activity_button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(avtivityName, "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(avtivityName, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(avtivityName, "OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(avtivityName, "OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(avtivityName, "OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(avtivityName, "OnResume");
    }
}
