import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class PR131mainEscriu {
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR131HashMapData.ser";
        PR131hashmap objeto = new PR131hashmap();

        objeto.diccionario.put("alex", 20);
        objeto.diccionario.put("cristian", 24);
        objeto.diccionario.put("pau", 21);
        objeto.diccionario.put("susi", 20);
    
    
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
