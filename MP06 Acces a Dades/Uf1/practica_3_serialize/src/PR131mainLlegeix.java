import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class PR131mainLlegeix {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR131HashMapData.ser";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

		try {
            
            FileInputStream archivoEntrada = new FileInputStream(filePath);
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);

            // Lee el objeto desde el archivo .ser
            PR131hashmap objetoLeido = (PR131hashmap) objetoEntrada.readObject();

            // Accede al HashMap dentro del objeto
            HashMap<String, Integer> hashMapLeido = objetoLeido.getHashMap();

            // Ahora puedes trabajar con el HashMap
            for (String key : hashMapLeido.keySet()) {
                int value = hashMapLeido.get(key);
                System.out.println("Clave: " + key + ", Valor: " + value);
            }

            objetoEntrada.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
