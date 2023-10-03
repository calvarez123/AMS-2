import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Electrodomestic> listaelectrodomesticos = new ArrayList<>();
        List<Electrodomestic> listacloneselect = new ArrayList<>();

        Forn forn1 = new Forn();
        forn1.setNom("hornito1");
        forn1.setColor("rojo");
        forn1.setEficacia("buenisima");
        forn1.setMarca("siemens");
        forn1.setPreu(1000);
        
        Forn forn2 = new Forn();
        forn2.setNom("hornito2");


        Nevera neve1 = new Nevera();
        neve1.setNom("neverita1");
        Nevera neve2 = new Nevera();
        neve2.setNom("neverita2");

        Rentadora renta1 = new Rentadora();
        renta1.setNom("rentadora1");
        Rentadora renta2 = new Rentadora();
        renta2.setNom("rentadora2");
        

        listaelectrodomesticos.add(forn1);
        listaelectrodomesticos.add(forn2);

        listaelectrodomesticos.add(neve1);
        listaelectrodomesticos.add(neve2);

        listaelectrodomesticos.add(renta1);
        listaelectrodomesticos.add(renta2);

        Forn fornclonado1 = (Forn) forn1.clone();
        Forn fornclonado2 = (Forn) forn2.clone();
        listacloneselect.add(fornclonado1);
        listacloneselect.add(fornclonado2);

        Nevera neveclonado1 = (Nevera) neve1.clone();
        Nevera neveclonado2 = (Nevera) neve2.clone();
        listacloneselect.add(neveclonado1);
        listacloneselect.add(neveclonado2);
        
        Rentadora rerntaclonado1 = (Rentadora) renta1.clone();
        Rentadora rentaclonado2 = (Rentadora) renta2.clone();
        listacloneselect.add(rerntaclonado1);
        listacloneselect.add(rentaclonado2);


        

        System.out.println("Comparar las dos listas iguales");
        for (int i = 0; i < listaelectrodomesticos.size(); i++) {
            if (listaelectrodomesticos.get(i).equals(listaelectrodomesticos.get(i))) {
                System.out.println("Elemento "+i+" es igual en las dos listas");
            }
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Comparar la lista normal con los clones");
        for (int i = 0; i < listaelectrodomesticos.size(); i++) {
            if (listaelectrodomesticos.get(i).equals(listacloneselect.get(i))) {
                System.out.println("Elemento "+i+" es igual en las dos listas");
            }
        }
    }
}
