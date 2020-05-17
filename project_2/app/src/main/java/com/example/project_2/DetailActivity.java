package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    TextView detailnama;
    ImageView detailgambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String namabuah = getIntent().getStringExtra(Konstanta.NAMABUAH);
        int gambarbuah = getIntent().getIntExtra(Konstanta.GAMBARBUAH, 0);

        Log.d(TAG, "Nama :" + namabuah);
        Log.d(TAG, "Gambar :" + gambarbuah);

        detailnama = findViewById(R.id.tv_detail_namabuah);
        detailgambar = findViewById(R.id.iv_detail_gambarbuah);

        detailnama.setText(namabuah);
        detailgambar.setImageResource(gambarbuah);


        


    }
}
