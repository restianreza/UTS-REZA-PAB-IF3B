package com.reza.uts_reza_if3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Konfirmasi extends AppCompatActivity {
    TextView tvNama;
    TextView tvNomorPendaftaran;
    TextView tvJalurPendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        getSupportActionBar().setTitle("Konfirmasi Pendaftaran");

        tvNama = findViewById(R.id.tv_nama);
        tvNomorPendaftaran = findViewById(R.id.tv_no_pendaftaran);
        tvJalurPendaftaran = findViewById(R.id.tv_jalur_pendaftaran);

        Intent terima = getIntent();
        String terimaNama = terima.getStringExtra("inputNama");
        String terimaNoPendaftaran = terima.getStringExtra("inputNoPendaftaran");
        String terimaJalurPendaftaran = terima.getStringExtra("inputJalurPendaftaran");

        tvNama.setText(terimaNama);
        tvNomorPendaftaran.setText(terimaNoPendaftaran);
        tvJalurPendaftaran.setText(terimaJalurPendaftaran);
    }
}