package practica_2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class PR125cp {
    public static void main(String[] args) throws IOException {
        // Ruta del archivo que quieres copiar
        Path origen = Path.of("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/carpeta_movida/copiao.txt");

        // Ruta de destino donde quieres copiar el archivo
        Path destino = Path.of("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/copiao.txt");

        try {
            // Copiar el archivo
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("----El archivo se ha copiado correctamente.-----");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }


    }
}
