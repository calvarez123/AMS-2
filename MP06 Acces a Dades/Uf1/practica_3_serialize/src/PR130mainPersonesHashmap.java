import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PR130mainPersonesHashmap {
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "ArxiuEscriuPrimitives.dat";
        
        HashMap<String, Integer>  dicc = new HashMap<>();
        dicc.put("alex", 20);
        dicc.put("cristian", 24);
        dicc.put("pau", 21);
        dicc.put("yugeng", 22);
        dicc.put("susana", 23);

        
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            DataOutputStream dos = new DataOutputStream(fos);

            // asi se mete un hashmap en escritura primivita
            dos.writeInt(dicc.size());
            for (Map.Entry<String, Integer> entry : dicc.entrySet()) {
                dos.writeUTF(entry.getKey());   // Escribir la clave
                dos.writeInt(entry.getValue());  // Escribir el valor
            }
            
            dos.flush();
            fos.close();
            dos.close();

            System.out.println("Hashmap introducido");
            System.out.println("");
        

        } catch (IOException e) { e.printStackTrace(); }

        try {
            
            FileInputStream archivoEntrada = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(archivoEntrada);

            // Lee la cantidad de elementos en el HashMap
            int numElementos = dataInputStream.readInt();

            // Lee las claves y valores del HashMap
            for (int i = 0; i < numElementos; i++) {
                
                System.out.println(dataInputStream.readUTF()+" "+dataInputStream.readInt());
            }

            

            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
