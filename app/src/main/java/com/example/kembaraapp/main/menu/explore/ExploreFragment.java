package com.example.kembaraapp.main.menu.explore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kembaraapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Kamis, 4 Agustus 2022
        Membuat Explore Fragmen untuk menampilkan card tempat wisata yang diambil dari firebase
*/

public class ExploreFragment extends Fragment implements RecyclerInterface {

    private FirebaseDatabase myDatabase;
    private DatabaseReference myRef;
    private FirebaseStorage myStorage;
    private ArrayList<TempatWisata> tempatWisataList;
    private RecyclerAdapter adapter;
    private Context mContext;
    private CardView cardView;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_explore, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Firebase
       myRef = FirebaseDatabase.getInstance().getReference();

        // ArrayList
        tempatWisataList = new ArrayList<>();

        // get data from firebase
        GetDataFromFirebase();

        //Clear Arraylist
        ClearALl();

        return root;
    }

    private void GetDataFromFirebase() {
        Query query = myRef.child("tempatwisata");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    TempatWisata tempatWisata = new TempatWisata();
                    tempatWisata.setName(dataSnapshot.child("name").getValue().toString());
                    tempatWisata.setDescription(dataSnapshot.child("description").getValue().toString());
                    tempatWisata.setImageUrl(dataSnapshot.child("image").getValue().toString());
                    tempatWisata.setLatitude(dataSnapshot.child("latitude").getValue().toString());
                    tempatWisata.setLongitude(dataSnapshot.child("longitude").getValue().toString());
                    System.out.println("ini longitude ges :" + tempatWisata.getLongitude());
                    tempatWisataList.add(tempatWisata);
                }
                adapter = new RecyclerAdapter(getContext().getApplicationContext(), tempatWisataList, ExploreFragment.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void ClearALl() {
        if(tempatWisataList != null) {
            tempatWisataList.clear();

            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        tempatWisataList = new ArrayList<>();
    }

    @Override
    //mengirim data ke activity detail tempat wisata dengan intent
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext().getApplicationContext(), ExploreDetailActivity.class);
        intent.putExtra("name", tempatWisataList.get(position).getName());
        intent.putExtra("description", tempatWisataList.get(position).getDescription());
        intent.putExtra("image", tempatWisataList.get(position).getImageUrl());
        intent.putExtra("longitude", tempatWisataList.get(position).getLongitude());
        intent.putExtra("latitude", tempatWisataList.get(position).getLatitude());
        startActivity(intent);
    }
}