package com.reza.uts_reza_if3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnDaftar;
    EditText etNama;
    EditText etNoPendaftaran;
    CheckBox cbKonfirmasi;
    AutoCompleteTextView actvJalurPendaftaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Formulir Pendaftaran");

        String[] type = new String[] {"Tes Tertulis", "Jalur Tanpa Tes", "Ujian Saingan Masuk"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                type
        );

        etNama = findViewById(R.id.et_namalengkap);
        etNoPendaftaran = findViewById(R.id.et_nomorpendaftaran);
        actvJalurPendaftaran = findViewById(R.id.atv_jalur_pendaftaran);
        actvJalurPendaftaran.setAdapter(adapter);
        cbKonfirmasi = findViewById(R.id.cb_konfirmasi);
        btnDaftar = findViewById(R.id.btn_daftar);


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = etNama.getText().toString();
                String NoPendaftaran = etNoPendaftaran.getText().toString();
                String JalurPendaftaran = actvJalurPendaftaran.getText().toString();

                if (Nama.trim().equals("")) {
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else if (NoPendaftaran.trim().equals("")) {
                    etNoPendaftaran.setError("No.Pendaftaran Tidak Boleh Kosong");
                }
                else if (JalurPendaftaran.trim().isEmpty()) {
                    actvJalurPendaftaran.setError("Pilih Jalur Pendaftaran Terlebih Dahulu");
                }
                else {
                    if (cbKonfirmasi.isChecked()) {
                        Intent daftar = new Intent(MainActivity.this, Konfirmasi.class);
                        daftar.putExtra("inputNama", Nama);
                        daftar.putExtra("inputNoPendaftaran", NoPendaftaran);
                        daftar.putExtra("inputJalurPendaftaran", JalurPendaftaran);
                        startActivity(daftar);
                    }
                    else {
                        cbKonfirmasi.setError("Konfirmasi Terlebih Dahulu");
                    }
                }
            }
        });

    }
}