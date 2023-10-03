package com.example.practica2_adivina_numero;

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

import com.example.practica2_adivina_numero.RankingActivity;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private int intentosnumero = 0;
    private int aleatorio = 0;
    static ArrayList<Ranking> rankings;
    class Ranking {
        private String name;
        private int intentos;
        private int numero;

        public Ranking(String name, int intentos, int numero) {
            this.name = name;
            this.intentos = intentos;
            this.numero = numero;
        }

        // Métodos getter
        public String getName() {
            return name;
        }

        public int getIntentos() {
            return intentos;
        }

        public int getNumero() {
            return numero;
        }

        // Métodos setter
        public void setName(String name) {
            this.name = name;
        }

        public void setIntentos(int intentos) {
            this.intentos = intentos;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rankings = new ArrayList<Ranking>();


        int duration = Toast.LENGTH_SHORT;

        Random r = new Random();
        generarAleatorio();

        Intent intent = new Intent(MainActivity.this, RankingActivity.class);



        final EditText editText = findViewById(R.id.textousu);
        final TextView intentos = findViewById(R.id.intentos);class Ranking {
            private String name;
            private int intentos;
            private int numero;

            public Ranking(String name, int intentos, int numero) {
                this.name = name;
                this.intentos = intentos;
                this.numero = numero;
            }

            // Métodos getter
            public String getName() {
                return name;
            }

            public int getIntentos() {
                return intentos;
            }

            public int getNumero() {
                return numero;
            }

            // Métodos setter
            public void setName(String name) {
                this.name = name;
            }

            public void setIntentos(int intentos) {
                this.intentos = intentos;
            }

            public void setNumero(int numero) {
                this.numero = numero;
            }

        }
        final TextView textoscroll = findViewById(R.id.scrolltext);
        final Button button = findViewById(R.id.button1);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentosnumero = intentosnumero + 1;
                intentos.setText("Intentos = "+ intentosnumero);

                try {

                    String textoIngresado = editText.getText().toString();
                    int numeroEntero = Integer.parseInt(textoIngresado);
                    if (numeroEntero == aleatorio){
                        Toast.makeText(MainActivity.this, "Adivinado", duration).show();
                        textoscroll.append("El numero era "+aleatorio+"\n");
                        mostrarGanaste(intentosnumero,intent);
                        generarAleatorio();
                        intentosnumero = 0;
                        Ranking jugador = new Ranking("nombre",intentosnumero,aleatorio);

                        editText.setText("");

                    } else {
                        if (numeroEntero < aleatorio){
                            textoscroll.append("El numero es mayor que "+numeroEntero+"\n");
                            editText.setText("");
                            Toast.makeText(MainActivity.this, "El numero es mayor que "+numeroEntero, duration).show();
                        } else if (numeroEntero > aleatorio){
                            textoscroll.append("El numero es menor que "+numeroEntero+"\n");
                            Toast.makeText(MainActivity.this, "El numero es menor que "+numeroEntero , duration).show();
                            editText.setText("");
                        }
                    }
                } catch (NumberFormatException e) {

                }

            }
        });




    }
    public void mostrarGanaste(int intentosnumero,Intent intent) {
        // Crear un constructor de AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Configurar el título y el mensaje
        builder.setTitle("Felicidades")
                .setMessage("Has adivinado el numero con solo "+intentosnumero+" intentos.");

        // Configurar botones y acciones
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


                dialog.dismiss(); // Cerrar el cuadro de diálogo
            }
        });


        // Mostrar el AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void generarAleatorio() {
        Random random = new Random();
        aleatorio = random.nextInt(100) + 1;
    }

    public static class RankingActivity1 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ranking1);

            // Obtén una referencia al TextView en tu diseño (layout)
            TextView textView = findViewById(R.id.textView);

            // Configura el texto del TextView con "Hola, mundo"
            textView.setText("Hola, mundo");
        }
    }
}
