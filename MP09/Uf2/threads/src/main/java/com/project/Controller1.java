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
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10
    ,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24;
    
    @FXML
    private AnchorPane container;
    

    private List<String> imageUrls = List.of(
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png",
        "/assets/image.png", "/assets/image.png", "/assets/image.png");    
        private int currentImageIndex = 0;

 

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void loadImage() {
    System.out.println("Loading images...");

    img1.setImage(null);
    loadNextImage();
}

    private void loadNextImage() {
        if (currentImageIndex < imageUrls.size()) {
            String imageUrl = imageUrls.get(currentImageIndex);
            ImageView targetImageView = getImageViewById(currentImageIndex);
            
    
            loadImageBackground(imageUrl, (image) -> {
                System.out.println("Image loaded");
                targetImageView.setImage(image);
                
            
                currentImageIndex++;
                loadNextImage();
            });
        }
    }
    
    private ImageView getImageViewById(int index) {
        return switch (index) {
            case 0 -> img1;
            case 1 -> img2;
            case 2 -> img3;
            case 3 -> img4;
            case 4 -> img5;
            case 5 -> img6;
            case 6 -> img7;
            case 7 -> img8;
            case 8 -> img9;
            case 9 -> img10;
            case 10 -> img11;
            case 11 -> img12;
            case 12 -> img13;
            case 13 -> img14;
            case 14 -> img15;
            case 15 -> img16;
            case 16 -> img17;
            case 17 -> img18;
            case 18 -> img19;
            case 19 -> img20;
            case 20 -> img21;
            case 21 -> img22;
            case 22 -> img23;
            case 23 -> img24;
            default -> null;
        };
    }


    public void loadImageBackground(String imageUrl, Consumer<Image> callBack) {
        // Use a thread to avoid blocking the UI
        CompletableFuture<Image> futureImage = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate a loading time
                Thread.sleep(100);

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
