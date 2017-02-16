package com.kosanworks.belajardoa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.kosanworks.belajardoa.doa.Bercermin;
import com.kosanworks.belajardoa.doa.Berpakaian;
import com.kosanworks.belajardoa.doa.SebelumBelajar;
import com.kosanworks.belajardoa.doa.KeduaOrangTua;
import com.kosanworks.belajardoa.doa.KeluarRumah;
import com.kosanworks.belajardoa.doa.MasukRumah;
import com.kosanworks.belajardoa.doa.NaikKendaraan;
import com.kosanworks.belajardoa.doa.SebelumMakan;
import com.kosanworks.belajardoa.doa.SebelumMandi;
import com.kosanworks.belajardoa.doa.SebelumTidur;
import com.kosanworks.belajardoa.doa.SesudahMakan;
import com.kosanworks.belajardoa.doa.SesudahTidur;

public class BelajarDoa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bercermin);
        setContentView(R.layout.activity_belajar_doa);
    }

    public void sesudah_tidur(View view) {
        Intent i = new Intent(BelajarDoa.this, SesudahTidur.class);
        startActivity(i);
    }

    public void sebelum_tidur(View view) {
        Intent i = new Intent(BelajarDoa.this, SebelumTidur.class);
        startActivity(i);
    }

    public void sebelum_mandi(View view) {
        Intent i = new Intent(BelajarDoa.this, SebelumMandi.class);
        startActivity(i);
    }


    public void sesudah_mandi(View view) {
    }

    public void berpakaian(View view) {
        Intent i = new Intent(BelajarDoa.this, Berpakaian.class);
        startActivity(i);
    }

    public void bercermin(View view) {
        Intent i = new Intent(BelajarDoa.this, Bercermin.class);
        startActivity(i);
    }

    public void sebelum_makan(View view) {
        Intent i = new Intent(BelajarDoa.this, SebelumMakan.class);
        startActivity(i);
    }

    public void sesudah_makan(View view) {
        Intent i = new Intent(BelajarDoa.this, SesudahMakan.class);
        startActivity(i);
    }

    public void keluar_rumah(View view) {
        Intent i = new Intent(BelajarDoa.this, KeluarRumah.class);
        startActivity(i);
    }

    public void naik_kendaraan(View view) {
        Intent i = new Intent(BelajarDoa.this, NaikKendaraan.class);
        startActivity(i);
    }

    public void masuk_rumah(View view) {
        Intent i = new Intent(BelajarDoa.this, MasukRumah.class);
        startActivity(i);
    }

    public void kedua_orang_tua(View view) {
        Intent i = new Intent(BelajarDoa.this, KeduaOrangTua.class);
        startActivity(i);
    }

    public void belajar(View view) {
        Intent i = new Intent(BelajarDoa.this, SebelumBelajar.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startService(new Intent(this, AudioService.class));
    }
}