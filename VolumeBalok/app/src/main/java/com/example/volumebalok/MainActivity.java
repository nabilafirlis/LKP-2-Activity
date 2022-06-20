package com.example.volumebalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtPjg , edtLbr , edtTgg ;
    private Button btHt;
    private TextView tvHsl;
    private static final String STATE_HASIL = "state_hasil";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPjg = (EditText) findViewById(R.id.edt_pjg);
        edtLbr = (EditText) findViewById(R.id.edt_lbr);
        edtTgg = (EditText) findViewById(R.id.edt_tgg);
        btHt =(Button) findViewById(R.id.bt_ht);
        tvHsl =(TextView) findViewById(R.id.tv_hsl);

        btHt.setOnClickListener(this);

        if(savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvHsl.setText(hasil);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_ht){
            String pjg = edtPjg.getText().toString().trim();
            String lbr = edtPjg.getText().toString().trim();
            String tgg = edtTgg.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(pjg)){
                isEmptyFields = true;
                edtPjg.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(lbr)) {
                isEmptyFields = true;
                edtLbr.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tgg)) {
                isEmptyFields = true;
                edtTgg.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                double p = Double.parseDouble(pjg);
                double l = Double.parseDouble(lbr);
                double t = Double.parseDouble(tgg);
                double luas = p*l*t ;
                tvHsl.setText(String.valueOf(luas));

                isEmptyFields = true;
                edtPjg.setError("Field ini tidak boleh kosong");
            }

        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL,tvHsl.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
