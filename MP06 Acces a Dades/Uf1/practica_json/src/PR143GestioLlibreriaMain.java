import java.io.File;
import java.util.List;


public class PR143GestioLlibreriaMain {
    public static void main(String[] args) {
        try {
            // Ruta del archivo JSON
            String filePath = "src/data/llibres_input.json";

            // Crear un objeto ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y cargarlo en una lista de objetos
            List<MiEstructuraDeDatos> datos = objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, MiEstructuraDeDatos.class));

            // Ahora puedes trabajar con los datos en la memoria
            for (MiEstructuraDeDatos dato : datos) {
                System.out.println("Título: " + dato.getTitulo());
                System.out.println("Autor: " + dato.getAutor());
                // ...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
