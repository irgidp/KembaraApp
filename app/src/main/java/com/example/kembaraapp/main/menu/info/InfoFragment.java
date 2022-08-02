package com.example.kembaraapp.main.menu.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.kembaraapp.R;


import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    /*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Rabu, 29 Juni 2022
        Membuat class InfoFragment untuk deklrasi info fragment halaman
*/
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.pager);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Fragment> list = new ArrayList<>();
        list.add(new InfoFragment1());
        list.add(new InfoFragment2());
        list.add(new InfoFragment3());

        pagerAdapter = new InfoViewModel(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }

}