package com.example.hostme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btmNView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        btmNView = findViewById(R.id.bottomNav);
        btmNView.setSelectedItemId(R.id.home1);
        HomeFragment hfrag = new HomeFragment();
        hfrag.setContext(MainActivity.this);
        LoadFragment(hfrag,true);
        btmNView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home1:
                        LoadFragment(new HomeFragment(),false);
                        break;
                    case R.id.search:
                        LoadFragment(new HomeFragment(),false);
                        break;
                    case R.id.gallery:
                        LoadFragment(new HomeFragment(),false);
                        break;
                    default:
                        LoadFragment(new HomeFragment(),false);
                        break;
                }

                return true;
            }
        });
    }
    private void LoadFragment(Fragment fragment, boolean b) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (b){
            ft.add(R.id.frameLayout,fragment);
        }
        else{
            ft.replace(R.id.frameLayout,fragment);
        }
        ft.commit();
    }
}