package com.dika.cardviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private Context mContext;
    private List<Mahasiswa> mhsList;

    public MahasiswaAdapter(Context mContext, List<Mahasiswa> mhsList) {
        this.mContext = mContext;
        this.mhsList = mhsList;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mahasiswa_card_view, parent, false);

        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        final Mahasiswa mahasiswa = mhsList.get(position);
        holder.txtNim.setText(mahasiswa.getNim());
        holder.txtNama.setText(mahasiswa.getNama());

        Glide.with(mContext).load(mahasiswa.getPhoto()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mahasiswa.getNama() + "Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mhsList.size();
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNim, txtNama;
        private ImageView thumbnail;

        public MahasiswaViewHolder(@NonNull View view) {
            super(view);
            txtNim = (TextView)view.findViewById(R.id.nim);
            txtNama = (TextView)view.findViewById(R.id.nama);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }
}
