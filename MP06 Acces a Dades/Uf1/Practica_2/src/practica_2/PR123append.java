package practica_2;

import java.io.FileWriter;
import java.io.IOException;

public class PR123append {
    public static void main(String[] args) throws IOException{
        FileWriter escribirArchivo = new FileWriter("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/frasesMatrix.txt", true);
            escribirArchivo.write("\n·Yo sólo puedo mostrarte la puerta\n");
            escribirArchivo.write("·Tú eres quien la tiene que atravesar");
            escribirArchivo.close();
            System.out.println("------------append con exito---------------");
    }
}
