package practica_2;

import java.io.FileWriter;
import java.io.IOException;

public class PR123sobreescriu {
    public static void main(String[] args) throws IOException {
        try {
            FileWriter escribirArchivo = new FileWriter("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/frasesMatrix.txt");
            escribirArchivo.write("·Yo sólo puedo mostrarte la puerta\n");
            escribirArchivo.write("·Tú eres quien la tiene que atravesar");
            
            escribirArchivo.close();
            System.out.println("-----Sobreescrito con exito-----");

            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
