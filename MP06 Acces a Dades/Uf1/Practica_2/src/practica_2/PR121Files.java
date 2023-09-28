package practica_2;

import java.io.File;
import java.io.IOException;

public class PR121Files {
    public static void main(String[] args) throws IOException {
        
        //Este codigo crea una carpeta y si ya existe no la crea
        File dir = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles");
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'MyFiles'");
            }
        }

        //Este codigo crea archivos
        File archivo1 = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/file1.txt");
        boolean exito = archivo1.createNewFile();
        if (exito) {
            System.out.println("Se ha creado el archivo "+ archivo1.getName());
        } else {
            System.out.println("El archivo "+ archivo1.getName()+" no se ha podido crear");
        }

        File archivo2 = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/file2.txt");
        exito = archivo2.createNewFile();
        if (exito) {
            System.out.println("Se ha creado el archivo "+ archivo2.getName());
        } else {
            System.out.println("El archivo "+ archivo2.getName()+" no se ha podido crear");
        }
    
        //Codigo para  Renombrar un archivo

        File rename = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles/renamedFile.txt");
        exito = archivo2.renameTo(rename);
        if (exito) {
            System.out.println("El archivo se ha renombrado con éxito.");
        } else {
            System.out.println("No se pudo renombrar el archivo.");
        }

        //Codigo que lista los archivos que hay una carpeta
        File carpeta = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles");
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Lista los archivos en la carpeta
            File[] archivos = carpeta.listFiles();
            
            // Itera a través de los archivos y muestra sus nombres
            System.out.println("El nombre de los archivos de la carpeta "+carpeta.getName()+" son:");
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    System.out.println(archivo.getName());
                }
            }
        } else {
            System.out.println("La carpeta no existe o no es un directorio válido.");
            
        }
        //Borrar un archivo

            boolean archivoBorrar = archivo1.delete();
            if (archivoBorrar) {
                System.out.println("Se ha borrado el archivo "+ archivo1.getName());
            } else {
                System.out.println("El archivo "+ archivo1.getName()+" no se ha podido borrar");
            }

            //Codigo que lista los archivos que hay una carpeta
        carpeta = new File("/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/MyFiles");
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Lista los archivos en la carpeta
            File[] archivos = carpeta.listFiles();
            
            // Itera a través de los archivos y muestra sus nombres
            System.out.println("El nombre de los archivos de la carpeta "+carpeta.getName()+" son:");
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    System.out.println(archivo.getName());
                }
            }
        } else {
            System.out.println("La carpeta no existe o no es un directorio válido.");
            
        }
    }
}
