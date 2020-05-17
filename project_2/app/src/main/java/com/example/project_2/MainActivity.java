package com.example.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String [] namabuah = {"Durian", "Apel", "Strobery", "Alpukat", "Kiwi", "Semangka"};
    int [] gambarBuah = {
            R.drawable.durian,
            R.drawable.apel,
            R.drawable.strobery,
            R.drawable.alpukat,
            R.drawable.kiwi,
            R.drawable.semangka,

    };
    int [] suarabuah = {
            R.raw.durian,
            R.raw.apel,
            R.raw.strobery,
            R.raw.alpukat,
            R.raw.kiwi,
            R.raw.semangka,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, namabuah,gambarBuah);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer.create(MainActivity.this, suarabuah [position] ).start();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(Konstanta.NAMABUAH, namabuah[position]);
                intent.putExtra(Konstanta.GAMBARBUAH, gambarBuah[position]);
                startActivity(intent);
            }
        });

    }

}
