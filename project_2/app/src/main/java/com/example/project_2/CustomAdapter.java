package com.example.project_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private String[] namabuah;
    private int[] gambarbuah;

    public CustomAdapter(@NonNull Context context1, String [] namabuah, int []gambarbuah ){
        super(context1, R.layout.item_buah, namabuah);
        this.context = context1;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //atur layout item
        LayoutInflater layoutInflater;
        View view = LayoutInflater.from(context).inflate(R.layout.item_buah, parent, false );

        //findview semua komponen yang ada di item
        ImageView ivgambarbuah = view.findViewById(R.id.iv_item_gambarbuah);
        TextView tvbuah = view.findViewById(R.id.tv_item_namabuah);

        //set data
        tvbuah.setText(namabuah[position]);
        ivgambarbuah.setImageResource(gambarbuah[position]);

        return view;
    }
}
