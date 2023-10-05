import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PR131mainLlegeix {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuObjectes.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        
        System.out.println("");

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

            PR131hashmap objeto = (PR131hashmap) ois.readObject();

            System.out.println(objeto);
			ois.close();
			fis.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
    }
}
