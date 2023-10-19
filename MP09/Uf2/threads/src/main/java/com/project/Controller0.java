package com.project;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class Controller0 {
    Random random = new Random();
        

    @FXML
    private Button button0, button1, button2, button3;
    @FXML
    private AnchorPane container;
    @FXML
    private Label percentatge0, percentatge1 , percentatge2;
    @FXML
    private ProgressBar progress0, progress1 , progress2;
    
    private ExecutorService executor = Executors.newFixedThreadPool(3); // Creem una pool de dos fils

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void runTask() {
        
        backgroundTask(0);
        backgroundTask(1);
        backgroundTask(2);
    }

    private void backgroundTask(int index) {
        // Executar la tasca
        executor.submit(() -> {
            
            try {
                for (int i = 0; i <= 100; i++) {
                    final int currentValue = i;
                    // linea uno

                    if (index == 0) {
                        // Actualitzar el Label en el fil d'aplicació de l'UI
                        Platform.runLater(() -> {
                            String porcentaje0 = percentatge0.getText();
                            percentatge0.setText(String.valueOf(currentValue) + "%");
                            
                            progress0.setProgress(currentValue/100.0);
                            if (porcentaje0 == "100%"){
                                stopExecutor();
                            }
                            
                        });
                        Thread.sleep(100);

                    }
                    //linea 2
                    if (index == 1) {
                        // Actualitzar el Label en el fil d'aplicació de l'UI
                        String porcentaje1 = percentatge0.getText();

                        int randomNumber = random.nextInt(3) + 2; 
                        int numeroAleatorio = (random.nextInt(3) + 3);
                        numeroAleatorio = numeroAleatorio*1000;
                        System.out.println(randomNumber);
                        int numero = currentValue+randomNumber;
                        
                        Platform.runLater(() -> {
                            percentatge1.setText(String.valueOf(numero) + "%");
                            progress1.setProgress(numero/100.0);
                            if (porcentaje1 == "100%"){
                                stopExecutor();
                            }

                        });
                        Thread.sleep(numeroAleatorio);
                    }

                    if (index == 2) {
                        // Actualitzar el Label en el fil d'aplicació de l'UI
                        Platform.runLater(() -> {
                            String porcentaje2 = percentatge0.getText();
                            percentatge2.setText(String.valueOf(currentValue) + "%");
                            progress2.setProgress(currentValue/100.0);
                            if (porcentaje2 == "100%"){
                                stopExecutor();
                            }
                        });
                        Thread.sleep(1000);
                    }

                    System.out.println("Updating label: " + index + ", Value: " + currentValue);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    
    // Aquesta funció la cridaries quan vulguis tancar l'executor (per exemple, quan tanquis la teva aplicació)
    public void stopExecutor() {
        executor.shutdown();
    }

}