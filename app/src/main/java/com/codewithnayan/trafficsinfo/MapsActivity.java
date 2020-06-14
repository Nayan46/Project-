package com.codewithnayan.trafficsinfo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    ArrayList<LatLng> arrayList=new ArrayList<LatLng>();
    LatLng Kathmandu = new LatLng(27.678137, 85.349244);
    LatLng Bharatpur = new LatLng(27.689523, 84.430713);
    LatLng Pokhara = new LatLng(28.209844, 83.986388);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(Kathmandu);
        arrayList.add(Bharatpur);
        arrayList.add(Pokhara);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapAPI=googleMap;


        for (int i=0;i<arrayList.size();i++){
            mapAPI.addMarker(new MarkerOptions().position(arrayList.get(i)).title("District Police Station"));
            mapAPI.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mapAPI.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }


//
//        LatLng Chitawan = new LatLng(27.689523, 84.430713);
//        mMap.addMarker(new MarkerOptions().position(Kathmandu).title("District Traffic Police Office, Chitawan"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chitawan));


    }
}
