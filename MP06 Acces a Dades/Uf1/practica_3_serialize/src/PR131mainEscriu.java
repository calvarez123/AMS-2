import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PR131mainEscriu {
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuObjectes.dat";
    PR131hashmap objeto = new PR131hashmap();

    objeto.put("alex", 20);
    objeto.put("cristian", 24);
    objeto.put("pau", 21);


    try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            
            
			oos.writeObject(objeto);
         

			oos.close();
			fos.close();

            System.out.println("Llest");

		} catch (IOException e) { e.printStackTrace(); 
        
        }
    }
    
}
