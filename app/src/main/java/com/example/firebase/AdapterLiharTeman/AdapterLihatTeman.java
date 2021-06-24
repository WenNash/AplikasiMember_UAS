package com.example.firebase.AdapterLiharTeman;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase.R;
import com.example.firebase.database.Teman;

public class AdapterLihatTeman extends RecyclerView.Adapter<AdapterLihatTeman.ViewHolder> {
    private  ArrayList<Teman> daftarTeman;
    private  Context context;

    public AdapterLihatTeman(ArrayList<Teman> daftarTeman, Context context) {
        this.daftarTeman = daftarTeman;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama;

        ViewHolder(View v){
            super(v);
            tvNama = (TextView) v.findViewById(R.id.tv_nama);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_teman,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nama = daftarTeman.get(position).getNama();
        holder.tvNama.setText(nama);

        holder.tvNama.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        holder.tvNama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return daftarTeman.size();
    }
}