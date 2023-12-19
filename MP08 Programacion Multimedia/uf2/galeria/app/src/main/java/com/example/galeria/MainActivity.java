package com.example.galeria;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;
    private Uri imageUri;

    private  ActivityResultLauncher<Intent> imagePickerLauncher;
    private ActivityResultLauncher<Intent> cameraLauncher;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageView);
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== RESULT_OK) {
                            Intent data = result.getData();
                            Bundle extras = data.getExtras();
                            Bitmap imageBitmap = (Bitmap) extras.get("data");
                            saveImageToGallery(imageBitmap);
                            imageView.setImageBitmap(imageBitmap);


                        }
                    }
                });


        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            ImageView imageView = findViewById(R.id.imageView);
                            imageView.setImageURI(uri);
                        }
                    }
                });

        Button btnOpenGallery = findViewById(R.id.btnOpenGallery);
        btnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery_result(v);
            }
        });

        Button btnTakePhoto = findViewById(R.id.btnTakePhoto);
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foton = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraLauncher.launch(foton);
            }
        });
    }

    public void openGallery_result (View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        //Launch activity to get result
        imagePickerLauncher.launch(intent);
    }


    private File createImageFile() throws IOException {
        // Crea un nombre de archivo único
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefijo */
                ".jpg",         /* sufijo */
                storageDir      /* directorio */
        );
        return image;
    }


    private void saveImageToGallery(Bitmap bitmap) {
        String imageTitle = "ImageTitle"; // Puedes cambiar esto a un nombre significativo
        String imageDescription = "ImageDescription"; // Puedes cambiar esto a una descripción significativa

        // Insertar la imagen en la galería de medios
        MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                imageTitle,
                imageDescription
        );

        // Notificar a la galería que se ha añadido una nueva imagen
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES))));
    }


}