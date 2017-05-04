package com.epam.androidtraining.lab2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.call_new_app);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this,
                        "com.epam.androidtraining.applicationwithpermission.permission.ACTIVITY_PERMISSION")==
                        PackageManager.PERMISSION_GRANTED) {
                    Intent customPermission = getPackageManager().getLaunchIntentForPackage("com.epam.androidtraining.applicationwithpermission");
                    if (customPermission != null) {
                        startActivity(customPermission);
                }else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{"com.epam.androidtraining.applicationwithpermission.permission.ACTIVITY_PERMISSION"},5);
                }
            }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int i=0; i<permissions.length;i++){
            if(permissions[i].equals("com.epam.androidtraining.applicationwithpermission.permission.ACTIVITY_PERMISSION")){
                if(grantResults[i]== PackageManager.PERMISSION_GRANTED){
                    Intent customPermission = getPackageManager().getLaunchIntentForPackage("com.epam.androidtraining.applicationwithpermission");
                    startActivity(customPermission);
                }
            }
        }

    }
}
