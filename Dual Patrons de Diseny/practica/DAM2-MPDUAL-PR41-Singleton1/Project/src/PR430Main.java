
import java.lang.reflect.Constructor;

public class PR430Main {
    public static void main(String[] args) {
        //--------------------------------Ejercicio 0------------------------------------------
        System.out.println("vamos a probar esto");
        System.out.println("puede tardar unos segundos");
        System.out.println("------Pantalla de carga 1-----");
        PR430Objecte instance1 = PR430Objecte.getInstance("cristian", "alex", 20);
        System.out.println(instance1.toString());

        System.out.println("------Pantalla de carga 2-----");
        PR430Objecte instance2 = PR430Objecte.getInstance("Alex", "Martinez", 20);
        System.out.println(instance2.toString());

        System.out.println("------Pantalla de carga 3-----");
        PR430Objecte instance3 = PR430Objecte.getInstance("Yuheng", "Zhou", 19);
        System.out.println(instance2.toString());

        


    }

}