import java.io.Serializable;
import java.util.Objects;

public class PR132persona implements Serializable{
    private String nom;
    private String cognom;
    private int edat;

    public PR132persona(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
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

    public PR132persona() {
    }

    public PR132persona nom(String nom) {
        setNom(nom);
        return this;
    }

    public PR132persona cognom(String cognom) {
        setCognom(cognom);
        return this;
    }

    public PR132persona edat(int edat) {
        setEdat(edat);
        return this;
    }


    @Override
    public String toString() {
        return "nom=" + getNom() + "  " +
            "cognom=" + getCognom() + "  " +
            "edat=" + getEdat();
    }
    
}
