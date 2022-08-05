package com.example.kembaraapp.main.menu.info;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/*
        NIM : 10119082
        Nama : Zainul Rifqi Muwaffaq
        Kelas : IF-2/VI
        Tanggal : Selasa, 2 Agustus 2022
        Membuat class InfoViewModel untuk deklrasi info view model
*/

public class InfoViewModel extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public InfoViewModel(FragmentManager fm, List<Fragment> fragmentList ) {
        super(fm);

        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}