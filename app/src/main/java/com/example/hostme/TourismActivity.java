package com.example.hostme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TourismActivity extends AppCompatActivity {

    RecyclerView tourActivityrecyclerView;
    ArrayList<TourismPlaces> tplaceactiList = new ArrayList<>();
    TourismActivityAdapter touradapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Beautiful Tourism Places");
        actionBar.setDisplayHomeAsUpEnabled(true);

        tourActivityrecyclerView = findViewById(R.id.tourActivityRecyclerView);
        searchView = findViewById(R.id.toursearchView);
        tourActivityrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if (getIntent()!=null){
            tplaceactiList = getIntent().getParcelableArrayListExtra("TourPlacesList");
        }
        touradapter = new TourismActivityAdapter(getApplicationContext(),tplaceactiList);
       tourActivityrecyclerView.setAdapter(touradapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredResult(newText.toLowerCase());
                return true;
            }
        });

    }

    private void filteredResult(String text) {
        ArrayList<TourismPlaces> filteredlist = new ArrayList<>();
        for (TourismPlaces place : tplaceactiList){
            if (place.getPlaceName().toLowerCase().contains(text)){
                filteredlist.add(place);
            }
        }
        if (filteredlist.isEmpty()){
            Toast.makeText(this, "No record found!", Toast.LENGTH_SHORT).show();
        }
        touradapter.setFilteredList(filteredlist);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}