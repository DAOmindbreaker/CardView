package com.dika.cardviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);

        mhsList = new ArrayList<>();
        adapter = new MahasiswaAdapter(this, mhsList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        preparedData();
    }

    private void preparedData(){
        int[] photos = new int[] {
                R.drawable.poto1,
                R.drawable.poto2,
                R.drawable.poto3,
                R.drawable.poto4,
                R.drawable.poto5,
                R.drawable.poto6,
        };

        mhsList.add(new Mahasiswa("311620803", "Bambang Laksono", photos[0]));
        mhsList.add(new Mahasiswa("311620123", "Nimas Setia Rahayu", photos[1]));
        mhsList.add(new Mahasiswa("311610234", "Alex Cristhoper", photos[2]));
        mhsList.add(new Mahasiswa("311612315", "Tanjung Asmara", photos[3]));
        mhsList.add(new Mahasiswa("311612253", "Hanum Ayu Mawardi", photos[4]));
        mhsList.add(new Mahasiswa("311612423", "Linggar Dwi Tungga", photos[5]));
    }
}
