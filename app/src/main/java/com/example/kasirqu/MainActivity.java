package com.example.kasirqu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNama, etHarga, etJumlah, etByr;
    Button btTotal, btHasil, btClear;
    TextView tvTot, tvKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama=(EditText) findViewById(R.id.namabarang);
        etHarga=(EditText) findViewById(R.id.hargabarang);
        etJumlah=(EditText) findViewById(R.id.jumlahbarang);
        etByr=(EditText) findViewById(R.id.jumlahbayar);
        btTotal=(Button) findViewById(R.id.btntotal);
        btHasil=(Button) findViewById(R.id.btnhasil);
        btClear=(Button) findViewById(R.id.btnclear);
        tvTot=(TextView) findViewById(R.id.hasiltotal);
        tvKembali=(TextView) findViewById(R.id.hasilkembali);

        btTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double jmlbarang, hrgbarang, total;
                jmlbarang=Double.valueOf(etJumlah.getText().toString().trim());
                hrgbarang=Double.valueOf(etHarga.getText().toString().trim());
                total=jmlbarang * hrgbarang;
                String total1=String.valueOf(total);
                tvTot.setText(total1);
            }
        });

        btHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bayar, totharga, hasil;
                totharga=Double.valueOf(tvTot.getText().toString().trim());
                bayar=Double.valueOf(etByr.getText().toString().trim());
                hasil=bayar - totharga;
                String hasil1=String.valueOf(hasil);
                tvKembali.setText(hasil1);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNama.setText("");
                etHarga.setText("");
                etJumlah.setText("");
                etByr.setText("");
                tvTot.setText("Hasil Total Disini");
                tvKembali.setText("Hasil Kembalian Disini");

            }
        });
    }
}