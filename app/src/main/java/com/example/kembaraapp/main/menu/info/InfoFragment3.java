package com.example.kembaraapp.main.menu.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kembaraapp.R;

/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Rabu, 29 Juni 2022
        Membuat class InfoFragment1 untuk deklrasi info fragment halaman 3
*/
public class InfoFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return (ViewGroup) inflater.inflate(R.layout.fragment_info3, container, false);
    }
}