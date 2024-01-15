package com.example.recicledview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array de recursos de drawable para las imágenes
        int[] imageDataSet = { R.drawable.gato, R.drawable.gato, R.drawable.gato , R.drawable.gato, R.drawable.gato , R.drawable.gato, R.drawable.gato };

        // Crear una instancia de ImageAdapter en lugar de CustomAdapter
        CustomAdapter imageAdapter = new CustomAdapter(this, imageDataSet);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageAdapter);
    }
}
