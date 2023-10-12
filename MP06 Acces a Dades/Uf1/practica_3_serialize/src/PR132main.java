import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PR132main {
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "PR132people.dat";

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        PR132persona persona1 = new PR132persona("Maria","Lopez",36);
        PR132persona persona2 = new PR132persona("Gustavo","Ponts",63);
        PR132persona persona3 = new PR132persona("Irene","Sales",54);
        // ESTO ES PARA GUARDAR LOS OBJETOS
        try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            //CON EL WRITEOBJECT
			oos.writeObject(persona1);
            oos.writeObject(persona2);
            oos.writeObject(persona3);

			oos.close();
			fos.close();

            System.out.println("-----------------Guardados con exito----------");

		} catch (IOException e) { e.printStackTrace(); }


        System.out.println("VAMOS A LEER LOS OBJETOS DE LA CLASE");
        try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

            PR132persona obj0 = (PR132persona) ois.readObject();
            PR132persona obj1 = (PR132persona) ois.readObject();
            PR132persona obj3 = (PR132persona) ois.readObject();

            

            System.out.println(obj1);
            System.out.println(obj1);
            System.out.println(obj3);

			ois.close();
			fis.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
       
    }
}
