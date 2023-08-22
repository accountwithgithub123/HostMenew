package com.example.hostme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    Context context;
    ArrayList<TourismPlaces> tourPlaceList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    public void setContext( Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tourMore = view.findViewById(R.id.tourMoreText);
        tourMore.setOnClickListener(v->{
            Intent tourintent = new Intent(context,TourismActivity.class);
            tourintent.putParcelableArrayListExtra("TourPlacesList", (ArrayList<? extends Parcelable>) tourPlaceList);
            startActivity(tourintent);
        });
        recyclerView = view.findViewById(R.id.tourRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(llm);
        addTourismPlace();
        TourismRecyViewAdapter tadapter = new TourismRecyViewAdapter(context,tourPlaceList);
       recyclerView.setAdapter(tadapter);
        return view;
    }

    private void addTourismPlace() {
        tourPlaceList.add(new TourismPlaces("Lahore",R.drawable.ic_baseline_image_24,31.5204,74.3587));
        tourPlaceList.add(new TourismPlaces("Islamabad",R.drawable.ic_baseline_image_24,33.6844,73.0479));
        tourPlaceList.add(new TourismPlaces("Karachi",R.drawable.ic_baseline_image_24,24.8607,67.0011));
        tourPlaceList.add(new TourismPlaces("Sargodha",R.drawable.ic_baseline_image_24,32.082466,72.669128));
        tourPlaceList.add(new TourismPlaces("Murree",R.drawable.ic_baseline_image_24,33.9070,73.3943));
    }
}