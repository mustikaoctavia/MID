package com.example.mid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText txtNilai1, txtNilai2, txtHasil;
    private RadioGroup rgOperasi;
    private Button btnClear;
    private double hasil=0;
    private boolean pilihOperasi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNilai1 = findViewById(R.id.txt_hasil);
        txtNilai2 = findViewById(R.id.txt_nilai2);
        txtHasil = findViewById(R.id.txt_hasil);
        rgOperasi = findViewById(R.id.rg_operasi);
        btnClear = findViewById(R.id.button);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                txtNilai1.setText("");
                txtNilai2.setText("");
                txtHasil.setText("");
                rgOperasi.clearCheck();
                pilihOperasi = false;
            }

        });

        rgOperasi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pilihOperasi = true;
                hitung();
            }
        });

    }

    public void hitung() {
        if (!pilihOperasi || txtNilai1.getText().toString().isEmpty() || txtNilai2.getText().toString().isEmpty()) {
            return;
        }

        double nilai1 = Double.parseDouble(txtNilai1.getText().toString());
        double nilai2 = Double.parseDouble(txtNilai2.getText().toString());

        if (rgOperasi.getCheckedRadioButtonId() == R.id.rb_tambah) {
            hasil = (int) (nilai1 + nilai2);
        } else if (rgOperasi.getCheckedRadioButtonId() == R.id.rb_kurang) {
            hasil = (int) (nilai1 - nilai2);
        } else if (rgOperasi.getCheckedRadioButtonId() == R.id.rb_kali) {
            hasil = (int) (nilai1 * nilai2);
        } else if (rgOperasi.getCheckedRadioButtonId() == R.id.rb_bagi) {
            hasil = nilai1 / nilai2;
        }

        if (rgOperasi.getCheckedRadioButtonId() != R.id.rb_bagi) {
            txtHasil.setText(String.valueOf((int) hasil));
        } else {
            txtHasil.setText(String.valueOf(hasil));
        }
    }

}