package com.zecode.z.skyegyptdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zecode.z.skyegyptdemo.Fragments.Fragment_innerTours;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Fragment f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlingDrawer();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handlingDrawer() {
        drawerLayout = findViewById(R.id.activity_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationView = findViewById(R.id.mainNavigationView);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();



                switch (menuItem.getItemId()) {
                    case R.id.honeyMoon:
                        Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.btnExternalTourism:
                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.internalTourism:
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        f = new Fragment_innerTours();
                        ft.replace(R.id.fragmentLayout,f);
                        ft.commit();
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();


                        return true;
                    case R.id.flightTicket:
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.dayTrip:
                        Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nileCruse:
                        Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.contactUs:
                        Toast.makeText(MainActivity.this, "6", Toast.LENGTH_SHORT).show();
                        return true;

                }



                return true;


            }
        });

    }
}
