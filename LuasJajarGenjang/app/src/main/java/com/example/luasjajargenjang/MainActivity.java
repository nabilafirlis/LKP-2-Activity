package com.example.luasjajargenjang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;
import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Alas, Tinggi;
    private Button Hitung;
    private TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alas = (EditText) findViewById(R.id.edt_alas);
        Tinggi = (EditText) findViewById(R.id.edt_tinggi);
        Hitung = (Button) findViewById(R.id.btn_htg);
        Hasil = (TextView) findViewById(R.id.txt_hasil);

        Alas.setOnClickListener(this);
        Tinggi.setOnClickListener(this);
        Hitung.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_htg) {
            String alas = Alas.getText().toString().trim();
            String tinggi = Tinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(alas)) {
                isEmptyFields = true;
                Alas.setError("Fields ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggi)) {
                isEmptyFields = true;
                Tinggi.setError("Fields ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double a = Double.parseDouble(alas);
                double t = Double.parseDouble(tinggi);
                double area = a * t;
                Hasil.setText(String.valueOf(area));
                i = new Intent(this, Result.class);
                i.putExtra("Hasil", Hasil.getText().toString());
                i.putExtra("ket", "Hasil Hitung");
                startActivity(i);
            }
                else{
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    startActivity(i);


                }
            }
        }
    }

