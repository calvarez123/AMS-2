package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.nombre);
        editTextLastName = findViewById(R.id.apellidos);
        editTextEmail = findViewById(R.id.mail);
        editTextPhone = findViewById(R.id.telefono);
    }
    public void saveData(View view) {
        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();

        String data = name + "," + lastName + "," + email + "," + phone + "\n";

        try {
            FileOutputStream fos = openFileOutput("data.txt", MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }
    }
}