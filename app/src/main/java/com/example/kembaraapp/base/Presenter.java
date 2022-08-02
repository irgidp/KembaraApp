package com.example.kembaraapp.base;

/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Rabu, 29 Juni 2022
        Membuat presenter dengan konsep MVP
*/

public interface Presenter <T extends View> {
    void onAttach(T view);
    void onDetach();
}
