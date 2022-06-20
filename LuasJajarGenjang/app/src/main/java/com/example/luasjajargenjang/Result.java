package com.example.luasjajargenjang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private TextView txtHasil , txtKet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtHasil = (TextView) findViewById(R.id.txt_hasil);
        txtKet = (TextView) findViewById(R.id.txt_ket);
        Bundle b = getIntent().getExtras();
        txtHasil.setText(b.getShort("Hasil"));
        txtKet.setText(b.getShort("ket"));

    }
}