package practica1.ejercicio1;
public final class PR430Objecte {

    private static PR430Objecte instance;
    private String nom;
    private String cognom;
    private int edat;


    private PR430Objecte(String nom, String cognom, int edat) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public static PR430Objecte getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new PR430Objecte( nom,cognom,edat);
        }
        return instance;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return this.cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return this.edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return String.format("%-10s: %s%n%-10s: %s%n%-10s: %d", "Nombre", getNom(), "Apellido", getCognom(), "Edad", getEdat());
    }

}
