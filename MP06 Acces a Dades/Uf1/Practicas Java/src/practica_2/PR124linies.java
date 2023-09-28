package practica_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PR124linies {
    public static void main(String[] args) throws IOException{
        int numero = 0;
        Random random = new Random();
        int aleatorio= 0;
        File archivo = new File ("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/Numeros_aleatorios.txt");
        boolean existe = archivo.createNewFile();
        if (existe) {
            System.out.println("creado");
        }else {
            System.out.println("ya existe");
        }

        try {
            FileWriter escribirArchivo = new FileWriter("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/Numeros_aleatorios.txt");
            
            while (numero<10){
            
            aleatorio = random.nextInt(100)+1;
            escribirArchivo.write(aleatorio+"\n");
            numero++;
            }
            escribirArchivo.close();
            System.out.println("se a escrito");

            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
}
