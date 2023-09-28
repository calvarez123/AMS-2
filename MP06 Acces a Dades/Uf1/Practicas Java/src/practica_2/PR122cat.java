package practica_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class PR122cat {
    public static void main(String[] args) throws IOException {
        // Generar aleatoriamente 0 o 1
        int aleatorio = new Random().nextInt(2);

        // Rutas para cada caso (0 y 1)
        Path rutaCaso0 = Path.of("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/frasesMatrix.txt");
        Path rutaCaso1 = Path.of("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles");

        // Seleccionar la ruta correspondiente al valor aleatorio
        Path rutaSeleccionada = (aleatorio == 0) ? rutaCaso0 : rutaCaso1;

        try {
            if (Files.exists(rutaSeleccionada)) {
                if (Files.isRegularFile(rutaSeleccionada)) {
                    System.out.println("Es un archivo:");
                    List<String> lineas = Files.readAllLines(rutaSeleccionada);
                    for (String linea : lineas) {
                        System.out.println(linea);
                    }
                } else if (Files.isDirectory(rutaSeleccionada)) {
                    System.out.println("Es una carpeta.");
                } else {
                    System.out.println("No es ni un archivo ni una carpeta.");
                }
            } else {
                System.out.println("El archivo o carpeta no existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al acceder al archivo o carpeta: " + e.getMessage());
        }
    }
}