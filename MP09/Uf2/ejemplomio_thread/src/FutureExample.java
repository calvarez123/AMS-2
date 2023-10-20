import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FutureExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Barras de Progreso");

        ProgressBar progressBar1 = new ProgressBar();
        ProgressBar progressBar2 = new ProgressBar();
        ProgressBar progressBar3 = new ProgressBar();

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(progressBar1, progressBar2, progressBar3);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        updateProgressBar(progressBar1);
        updateProgressBar(progressBar2);
        updateProgressBar(progressBar3);
    }

    private void updateProgressBar(ProgressBar progressBar) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                for (int i = 0; i <= 100; i++) {
                    final int percentage = i;
                    Platform.runLater(() -> {
                        progressBar.setProgress(percentage / 100.0);
                    });

                    try {
                        Thread.sleep(100); // Simula un cálculo que toma tiempo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        new Thread(task).start();
    }
}