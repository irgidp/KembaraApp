package com.example.kembaraapp.main.menu.explore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kembaraapp.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Kamis, 4 Agustus 2022
        Membuat Explore Daily Activity untuk menampilkan detail tempat wisata dan map
*/
public class ExploreDetailActivity extends AppCompatActivity {

    private ImageView image;
    private TextView namaTempat;
    private TextView description;
    private MapView mapView;

    Boolean isLocationGranted = false;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_detail);

        // inisialisasi view
        image = findViewById(R.id.image);
        namaTempat = findViewById(R.id.namaTempat);
        description = findViewById(R.id.description);
        mapView = findViewById(R.id.mapView);



        // mengambil data dari intent
        String nama, desc, imageUrl, longitude, latitude;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nama = bundle.getString("name");
            desc = bundle.getString("description");
            imageUrl = bundle.getString("image");
            longitude = bundle.getString("longitude");
            latitude = bundle.getString("latitude");

            double lat = Double.parseDouble(latitude);
            double lng = Double.parseDouble(longitude);

            namaTempat.setText(nama);
            description.setText(desc);
            Glide.with(this).load(imageUrl).into(image);

            // input map view
            mapView.onCreate(savedInstanceState);
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    // Add a marker in Sydney and move the camera
                    LatLng lokasi = new LatLng(lat, lng);
                    googleMap.addMarker(new MarkerOptions().position(lokasi).title(nama));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 18));

                }
            });
        }
    }
}