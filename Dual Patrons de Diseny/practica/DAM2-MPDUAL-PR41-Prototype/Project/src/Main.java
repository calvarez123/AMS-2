import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Electrodomestic> listaelectrodomesticos = new ArrayList<>();

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

        
    }
}
