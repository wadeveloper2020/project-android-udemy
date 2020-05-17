package com.example.project_5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.MyViewHolder> {


    private Context context;
    private List<CatatanModel> data = new ArrayList<>();

    public CatatanAdapter(Context context, List<CatatanModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CatatanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_catatan,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanAdapter.MyViewHolder holder, final int position) {
        holder.tvjudul.setText(data.get(position).getJudul());
        holder.tvjumlah.setText("Rp. "+data.get(position).getJumlah_hutang());
        holder.tvtanggal.setText(data.get(position).getTanggal());
        holder.tvtanggal.setTypeface(null, Typeface.ITALIC);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailCatatanActivity.class);
                intent.putExtra(DetailCatatanActivity.MY_ID, data.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvjudul,tvjumlah,tvtanggal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvjudul = itemView.findViewById(R.id.tv_judul);
            tvjumlah = itemView.findViewById(R.id.tv_jumlah);
            tvtanggal = itemView.findViewById(R.id.tv_tanggal);
        }
    }
}
