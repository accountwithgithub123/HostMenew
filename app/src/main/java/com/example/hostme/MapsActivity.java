package com.example.hostme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.hostme.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Double latitude = -34.00,longitude = 151.00;
        if (getIntent()!=null){
            latitude = getIntent().getDoubleExtra("Latitude",-34.00);
            longitude = getIntent().getDoubleExtra("Longitude",151);
        }
        latLng = new LatLng(latitude, longitude);
        SupportMapFragment mfag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mfag.getMapAsync(this::onMapReady);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MarkerOptions mopt = new MarkerOptions().position(latLng);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        mMap.addMarker(mopt);
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}