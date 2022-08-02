package com.example.kembaraapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kembaraapp.R;
import com.example.kembaraapp.main.MainActivity;


/*
        NIM : 10119059
        Nama : Irgi Dwiputra
        Kelas : IF-2/VI
        Tanggal : Selasa, 31 Mei 2022
        Membuat class SplashScreen untuk menampilkan splashscreen
*/
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*        getSupportActionBar().hide();*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}