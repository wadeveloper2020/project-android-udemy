package com.example.project_4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_4.model.ResultsItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    public static final String DATA_MOVIE = "datamovie";
    public static final String DATA_EXTRA = "dataextra";
    private Context context;
    private List<ResultsItem> data = new ArrayList<>();

    public MovieAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    //menyambungkan layout item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent , false);
        return new MyViewHolder(view);
    }

    //set data
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tvjudul.setText( data.get(position).getTitle());
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500"+ data.get(position)
            .getPosterPath())
            .into(holder.ivPoster);
/////////////////////////////////////////////////////////////////////////////////////
        holder.itemView.setOnClickListener(new View.OnClickListener() {            //
            @Override                                                              //
            public void onClick(View view) {                                       //
                Intent pindah = new Intent(context, MovieDetailActivity.class);    //
                Bundle bundle = new Bundle();                                      //
                bundle.putParcelable(DATA_MOVIE, Parcels.wrap(data.get(position)));//
                pindah.putExtra(DATA_EXTRA, bundle);                               //
                context.startActivity(pindah);                                     //
            }                                                                      //
        });                                                                        //
/////////////////////////////////////////////////////////////////////////////////////
    }

    //jumlah data
    @Override
    public int getItemCount() {
        return data.size();
    }

    //mengenalkan komponen dalam item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvjudul;
        ImageView ivPoster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvjudul = itemView.findViewById(R.id.tv_judul);
            ivPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
