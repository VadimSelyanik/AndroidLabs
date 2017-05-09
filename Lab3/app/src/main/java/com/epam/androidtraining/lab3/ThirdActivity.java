package com.epam.androidtraining.lab3;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    final String avtivityName = "Main Activity 3";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d(avtivityName, "OnCreate");
        textView = (TextView) findViewById(R.id.text_view1);
        String s = "List of running activities";
        try {
            ActivityInfo[] list = getPackageManager().getPackageInfo(getPackageName(),PackageManager.GET_ACTIVITIES).activities;

            for(int i = 0;i< list.length;i++)
            {
                s+= "\n"+list[i].name;

            }
        }
        catch (PackageManager.NameNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        textView.setText(s);
//        getParent().getParent().finish();
//        getParent().finish();
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
