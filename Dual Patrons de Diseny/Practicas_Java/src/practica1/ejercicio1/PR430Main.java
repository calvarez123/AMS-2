package practica1.ejercicio1;

import java.lang.reflect.Constructor;
//LOS DOS EJERCICIOS ESTAN EN EL MISMO ARCHIVO (EL EJERCICIO 2 Y 3 PIDEN THREADS QUE NO SABEMOS HACER)
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

        //--------------------------------Ejercicio 1------------------------------------------

        System.out.println("-----------------Singleton destruido-----------------------");

        System.out.println("------Pantalla de carga 1-----");
        PR430Objecte instance4 = getNewDestroyedInstance("manel", "ruano", 20);
        System.out.println(instance1.toString());

        System.out.println("------Pantalla de carga 2-----");
        PR430Objecte instance5 = getNewDestroyedInstance("albert", "palomares", 20);
        System.out.println(instance2.toString());

        System.out.println("------Pantalla de carga 3-----");
        PR430Objecte instance6 = getNewDestroyedInstance("marc", "ustero", 13);
        System.out.println(instance2.toString());


    }

    static PR430Objecte getNewDestroyedInstance (String nom, String cognom, int edat) {
        
        PR430Objecte result = null;
        try {
            Constructor<?>[] constructors = PR430Objecte.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                
                constructor.setAccessible(true);
                result = (PR430Objecte) constructor.newInstance(nom,cognom,edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}