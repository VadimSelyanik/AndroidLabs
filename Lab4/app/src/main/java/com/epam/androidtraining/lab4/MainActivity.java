package com.epam.androidtraining.lab4;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainFragment.OnChangeButtonListener{
    private final String MAIN_FRAGMENT_TAG = MainFragment.class.getName();
    private final String FIRST_FRAGMENT_TAG = FirstFragment.class.getName();
    private final String SECOND_FRAGMENT_TAG = SecondFragment.class.getName();
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private boolean fragmentState ;
    private final String FRAG_STATE = "FRAGMENT_STATE";
    private final String COLR1 = "COLOR1";
    private final String COLR2 = "COLOR2";

    private int color1 = Color.WHITE;
    private int color2 = Color.WHITE;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        MainFragment mainFragment = new MainFragment();
        fragmentTransaction.add(R.id.main_frgment_frame, mainFragment,MAIN_FRAGMENT_TAG);

        if(savedInstanceState!=null) {
            fragmentState = savedInstanceState.getBoolean(FRAG_STATE);
            color1 = savedInstanceState.getInt(COLR1);
            color2 = savedInstanceState.getInt(COLR2);
            firstFragment = (FirstFragment) fragmentManager.findFragmentByTag(FIRST_FRAGMENT_TAG);
            secondFragment = (SecondFragment)fragmentManager.findFragmentByTag(SECOND_FRAGMENT_TAG);
            if (firstFragment == null)
                firstFragment = new FirstFragment();
            if (secondFragment == null)
                secondFragment = new SecondFragment();
        }
        else {
            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.switch_frgment_frame, firstFragment, FIRST_FRAGMENT_TAG);
        }
        fragmentTransaction.commit();
        Log.d("MainActivity", "Create");
    }

    @Override
    public void onChangeFragmentButtonClicked() {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (!fragmentState){
            fragmentTransaction.replace(R.id.switch_frgment_frame,secondFragment,SECOND_FRAGMENT_TAG);
            secondFragment.setColor(color2);
            fragmentState = true;
        }
        else {
            fragmentTransaction.replace(R.id.switch_frgment_frame,firstFragment,FIRST_FRAGMENT_TAG);
            firstFragment.setColor(color1);
            fragmentState = false;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onChangeColorButtonClicked() {
        Random r = new Random(System.currentTimeMillis());
        TypedArray typedArray = getResources().obtainTypedArray(R.array.colors);
        int color = typedArray.getColor(Math.abs(r.nextInt()%10),0);
        if (fragmentState){
            secondFragment.setColor(color);
            secondFragment.getView().setBackgroundColor(color);
            color2 = color;
        }
        else {
            firstFragment.setColor(color);
            firstFragment.getView().setBackgroundColor(color);
            color1 = color;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(FRAG_STATE, fragmentState);
        outState.putInt(COLR1,color1);
        outState.putInt(COLR2, color2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "Resume");
    }
}
