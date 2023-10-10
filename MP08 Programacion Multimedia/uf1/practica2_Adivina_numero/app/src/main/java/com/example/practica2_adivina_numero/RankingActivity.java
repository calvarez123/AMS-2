package com.example.practica2_adivina_numero;
import static com.example.practica2_adivina_numero.MainActivity.rankings;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class RankingActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private ArrayList<MainActivity.Ranking> rankings = MainActivity.rankings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Intent intent = new Intent(this, MainActivity.class);
        // Obtén una referencia al TableLayout y a la ArrayList de Rankings
        tableLayout = findViewById(R.id.tableLayout);

        // Llena el TableLayout con los datos de la ArrayList de Rankings
        llenarTabla();

        final Button button2 = findViewById(R.id.atras);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }



    private void llenarTabla() {
        for (MainActivity.Ranking ranking : rankings) {
            TableRow row = new TableRow(this);

            TextView textViewNombre = new TextView(this);
            textViewNombre.setText(ranking.getName());

            TextView textViewIntentos = new TextView(this);
            textViewIntentos.setText(String.valueOf(ranking.getIntentos()));

            TextView textViewNumero = new TextView(this);
            textViewNumero.setText(String.valueOf(ranking.getNumero()));

            // Personaliza los TextView según tus necesidades
            textViewNombre.setTextSize(16);
            textViewIntentos.setTextSize(16);
            textViewNumero.setTextSize(16);


            textViewNombre.setPadding(0, 0, 16, 16);
            textViewIntentos.setPadding(0, 0, 16, 16);
            textViewNumero.setPadding(0, 0, 16, 16);

            row.addView(textViewNombre);
            row.addView(textViewIntentos);
            row.addView(textViewNumero);

            tableLayout.addView(row);
        }
    }
}