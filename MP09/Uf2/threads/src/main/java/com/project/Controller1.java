package com.project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Controller1 implements initialize {

    @FXML
    private Button button0, button1;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private AnchorPane container;
    @FXML
    private Label loading1;
    @FXML
    private Label loading2;

    private List<String> imageUrls = List.of("/assets/image.png", "/assets/image.png", "/assets/image.png");
    private int currentImageIndex = 0;

    @FXML
    public void initialize() {
        loading1.setVisible(false);
        loading2.setVisible(false);
    }

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void loadImage() {
        System.out.println("Loading image...");
        loading1.setVisible(true);
        loading2.setVisible(true);
        img1.setImage(null);
        img2.setImage(null);
        loadNextImage();
    }

    private void loadNextImage() {
        if (currentImageIndex < imageUrls.size()) {
            String imageUrl = imageUrls.get(currentImageIndex);
            ImageView targetImageView = currentImageIndex % 2 == 0 ? img1 : img2;
            Label targetLoadingLabel = currentImageIndex % 2 == 0 ? loading1 : loading2;
            
            loadImageBackground(imageUrl, (image) -> {
                System.out.println("Image loaded");
                targetImageView.setImage(image);
                targetLoadingLabel.setVisible(false);
                currentImageIndex++;
                loadNextImage(); // Load the next image
            });
        }
    }

    public void loadImageBackground(String imageUrl, Consumer<Image> callBack) {
        // Use a thread to avoid blocking the UI
        CompletableFuture<Image> futureImage = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate a loading time
                Thread.sleep(1000);

                // Load the data from the assets file
                Image image = new Image(getClass().getResource(imageUrl).toString());
                return image;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        })
        .exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        futureImage.thenAcceptAsync(result -> {
            callBack.accept(result);
        }, Platform::runLater);
    }
}
