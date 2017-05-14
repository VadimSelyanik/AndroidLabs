package com.epam.androidtraining.lab5;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private final String FIRST_FRAGMENT_TAG = FirstFragment.class.getName();
    private final String SECOND_FRAGMENT_TAG = SecondFragment.class.getName();
    private final String CUSTOM_FRAGMENT_TAG = CustomViewFragment.class.getName();
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private CustomViewFragment customViewFragment;
    private final String IMAGE_URL = "http://webneel.com/daily/sites/default/files/images/daily/09-2013/2-reflection-elephants-illusion-paintings-by-salvador-dali.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        customViewFragment = new CustomViewFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_for_fragments,customViewFragment,CUSTOM_FRAGMENT_TAG);
        fragmentTransaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView imageView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.navigation_image_view);
        Picasso.with(getBaseContext()).load(IMAGE_URL).into(imageView);
        //Picasso.with(getBaseContext()).load("sd")
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.first_fragment_item) {
            fragmentTransaction.replace(R.id.container_for_fragments,firstFragment,FIRST_FRAGMENT_TAG);
        } else if (id == R.id.second_fragment_item) {
            fragmentTransaction.replace(R.id.container_for_fragments,secondFragment, SECOND_FRAGMENT_TAG);
        } else if (id == R.id.custom_fragment_item){
            fragmentTransaction.replace(R.id.container_for_fragments,customViewFragment,CUSTOM_FRAGMENT_TAG);
        }
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
