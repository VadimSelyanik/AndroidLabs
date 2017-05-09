package com.epam.androidtraining.lab3;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String avtivityName = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(avtivityName, "OnCreate");
        Button button = (Button) findViewById(R.id.start_second_activity_button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
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
