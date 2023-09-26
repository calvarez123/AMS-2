package com.example.practica2_adivina_numero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence texttoast = "SI PULSAS ERES GUAI";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this, texttoast, duration);
        Random r = new Random();
        int aleatorio = r.nextInt((100)-1);

        final EditText editText = findViewById(R.id.textousu);
        String textoIngresado = editText.getText().toString();

        try {
            int numeroEntero = Integer.parseInt(textoIngresado); // Intenta convertir la cadena a un entero
            // Aquí puedes usar la variable "numeroEntero" que ahora contiene el valor como entero
            System.out.println("Número entero: " + numeroEntero);
        } catch (NumberFormatException e) {
            // Manejar una excepción en caso de que la conversión falle
            System.err.println("No se pudo convertir la cadena a un número entero.");
        }



        final Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });



    }

}