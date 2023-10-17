import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<String> productes;
    private int capacitatInicial = 10;

    public PR450Magatzem(ArrayList<String> productes, int capacitatInicial) {
        this.productes = productes;
        this.capacitatInicial = capacitatInicial;
    }

   

    public int getCapacitatInicial() {
        return this.capacitatInicial;
    }

    public void setCapacitatInicial(int capacitatInicial) {
        this.capacitatInicial = capacitatInicial;
    }


    public void addProducte(String producte) {
        if (productes.size() < capacitatInicial) {
            productes.add(producte);
        } else {
            System.out.println("El magatzem està ple. No es pot afegir més productes.");
        }
    }

    public void getProductes() {
        System.out.println("Productes al magatzem:");
        for (String producte : productes) {
            System.out.println(producte);
        }
    }
    public boolean removeProducte(String producte) {
        boolean removed = productes.remove(producte);
        if (removed) {
            System.out.println("Producte eliminat: " + producte);
        } else {
            System.out.println("No s'ha trobat el producte: " + producte);
        }
        return removed;
    }
}
