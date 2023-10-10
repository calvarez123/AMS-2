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

        Ranking ranking1 = new Ranking("Usuario1", 10, 42);
        Ranking ranking2 = new Ranking("Usuario2", 8, 56);
        Ranking ranking3 = new Ranking("Usuario3", 15, 29);
        Ranking ranking4 = new Ranking("Usuario4", 12, 73);
        Ranking ranking5 = new Ranking("Usuario5", 9, 64);

        rankings.add(ranking1);
        rankings.add(ranking2);
        rankings.add(ranking3);
        rankings.add(ranking4);
        rankings.add(ranking5);


        int duration = Toast.LENGTH_SHORT;

        Random r = new Random();
        generarAleatorio();

        Intent intent = new Intent(MainActivity.this, RankingActivity.class);



        final EditText editText = findViewById(R.id.textousu);
        final TextView intentos = findViewById(R.id.intentos);
        final TextView textoscroll = findViewById(R.id.scrolltext);
        final Button button = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.pantalla2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });



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
                        mostrarGanaste(intentosnumero);
                        generarAleatorio();
                        intentosnumero = 0;


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
    public void mostrarGanaste(int intentosnumero) {
        // Crear un constructor de AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Configurar el título y el mensaje
        builder.setTitle("Felicidades")
                .setMessage("Has adivinado el número con solo " + intentosnumero + " intentos.")
                .setCancelable(false); // Evitar que el diálogo se cierre tocando fuera de él

        // Agregar botón "Guardar score" (sí)
        builder.setPositiveButton("Guardar score", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Aquí puedes agregar el código para permitir al usuario ingresar su nombre
                // y guardar el score si selecciona "sí"

                // Crear un cuadro de diálogo personalizado para ingresar el nombre
                AlertDialog.Builder nameDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                nameDialogBuilder.setTitle("Ingresa tu nombre");

                final EditText input = new EditText(MainActivity.this);
                nameDialogBuilder.setView(input);

                nameDialogBuilder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombre = input.getText().toString();
                        Ranking jugador = new Ranking(nombre,intentosnumero,aleatorio);
                        rankings.add(jugador);

                        // Aquí puedes guardar el nombre y el score
                        // Puedes usar SharedPreferences o cualquier otra forma de almacenamiento de datos
                    }
                });

                nameDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                nameDialogBuilder.show();
            }
        });

        // Agregar botón "Aceptar" (no)
        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss(); // Cerrar el cuadro de diálogo
            }
        });

        // Mostrar el cuadro de diálogo
        builder.show();
    }
    public void generarAleatorio() {
        Random random = new Random();
        //aleatorio = random.nextInt(100) + 1;
        aleatorio = 3;
    }


}
