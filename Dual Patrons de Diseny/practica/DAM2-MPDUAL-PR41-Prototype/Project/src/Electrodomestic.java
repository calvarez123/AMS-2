public abstract class Electrodomestic {
    private String nom;
    private String color;
    private int preu;
    private String marca;
    private String eficacia;

    public Electrodomestic (){

    }

    public Electrodomestic(Electrodomestic target) {
        if (target != null) {
            this.nom = target.nom;
            this.color = target.color;
            this.preu = target.preu;
            this.marca = target.marca;
            this.eficacia = target.eficacia;
        }
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPreu() {
        return this.preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEficacia() {
        return this.eficacia;
    }

    public void setEficacia(String eficacia) {
        this.eficacia = eficacia;
    }

    @Override
    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", color='" + getColor() + "'" +
            ", preu='" + getPreu() + "'" +
            ", marca='" + getMarca() + "'" +
            ", eficacia='" + getEficacia() + "'" +
            "}";
    }

    public abstract Electrodomestic clone();
    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Electrodomestic)) return false;
        Electrodomestic cast2 = (Electrodomestic) object2;
        return cast2.nom == nom && cast2.color == color && cast2.eficacia == eficacia && cast2.preu== preu && cast2.marca == marca;
    }
}
