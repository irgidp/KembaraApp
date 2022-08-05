package com.example.kembaraapp.main.menu.explore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kembaraapp.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Kamis, 4 Agustus 2022
        Membuat RecyclerAdapter untuk menampilkan card tempat wisata yang diambil dari firebase
*/

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final RecyclerInterface recyclerInterface;
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<TempatWisata> tempatWisataList;

    public RecyclerAdapter(Context mContext, ArrayList<TempatWisata> tempatWisataList, RecyclerInterface recyclerInterface) {
        this.mContext = mContext;
        this.tempatWisataList = tempatWisataList;
        this.recyclerInterface = recyclerInterface;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tempat, parent, false);
        return new ViewHolder(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaTempat.setText(tempatWisataList.get(position).getName());
        holder.description.setText(tempatWisataList.get(position).getDescription());

        //imageview : glide library
        Glide.with(mContext)
                .load(tempatWisataList.get(position).getImageUrl())
                .into(holder.imageViewy);
    }

    @Override
    public int getItemCount() {
        return tempatWisataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Widgets;
        ImageView imageViewy;
        TextView namaTempat;
        TextView description;

        public ViewHolder(View view, RecyclerInterface recyclerInterface) {
            super(view);
            imageViewy = view.findViewById(R.id.imageViewy);
            namaTempat = view.findViewById(R.id.namaTempat);
            description = view.findViewById(R.id.description);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerInterface != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
