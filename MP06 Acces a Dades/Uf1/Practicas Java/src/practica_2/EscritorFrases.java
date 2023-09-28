package practica_2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorFrases {
    public static void main(String[] args) throws IOException {
        File archivo = new File ("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/frasesMatrix.txt");
        boolean existe = archivo.createNewFile();
        if (existe) {
            System.out.println("creado");
        }else {
            System.out.println("ya existe");
        }
        
        try {
            FileWriter escribirArchivo = new FileWriter("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/frasesMatrix.txt");
            escribirArchivo.write("·Yo sólo puedo mostrarte la puerta\n");
            escribirArchivo.write("·Tú eres quien la tiene que atravesar");
            
            escribirArchivo.close();
            System.out.println("se a escrito");

            
        } catch (Exception e) {
            e.printStackTrace(); 
        }




    }

}

