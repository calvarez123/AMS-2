
import java.lang.reflect.Constructor;

public class PR431Main {
    public static void main(String[] args) {
        //--------------------------------Ejercicio 1------------------------------------------

        System.out.println("-----------------Singleton destruido-----------------------");

        System.out.println("------Pantalla de carga 1-----");
        PR430Objecte instance4 = getNewDestroyedInstance("manel", "ruano", 20);
        System.out.println(instance4.toString());

        System.out.println("------Pantalla de carga 2-----");
        PR430Objecte instance5 = getNewDestroyedInstance("albert", "palomares", 20);
        System.out.println(instance5.toString());

        System.out.println("------Pantalla de carga 3-----");
        PR430Objecte instance6 = getNewDestroyedInstance("marc", "ustero", 13);
        System.out.println(instance6.toString());


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