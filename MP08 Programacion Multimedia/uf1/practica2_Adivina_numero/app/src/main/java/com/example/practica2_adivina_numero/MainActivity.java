package com.example.practica2_adivina_numero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int intentosnumero = 0;
    private int aleatorio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int duration = Toast.LENGTH_SHORT;

        Random r = new Random();
        generarAleatorio();


        final EditText editText = findViewById(R.id.textousu);
        final TextView intentos = findViewById(R.id.intentos);
        final TextView textoscroll = findViewById(R.id.scrolltext);
        final Button button = findViewById(R.id.button1);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    button.performClick();
                    return true;
                }
                return false;
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
                            Toast.makeText(MainActivity.this, "El numero es mayor que "+numeroEntero, duration).show();
                        } else if (numeroEntero > aleatorio){
                            textoscroll.append("El numero es menor que "+numeroEntero+"\n");
                            Toast.makeText(MainActivity.this, "El numero es menor que "+numeroEntero , duration).show();
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
                .setMessage("Has adivinado el numero con solo "+intentosnumero+" intentos.");

        // Configurar botones y acciones
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Código a ejecutar cuando se hace clic en el botón "Aceptar"
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
}
