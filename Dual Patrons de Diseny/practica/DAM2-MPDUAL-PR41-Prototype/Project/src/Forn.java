public class Forn extends Electrodomestic{
    
    private int temperatura;
    private String autonetejat;

    public Forn() {
    }

    public Forn(Forn target) {
        super(target);
        if (target != null) {
            this.temperatura = target.temperatura;
            this.autonetejat = target.autonetejat;
    }
        }
    

    @Override
    public Electrodomestic clone() {
        return new Forn(this);
    }
    
}
