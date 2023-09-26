public class Nevera extends Electrodomestic {
    
    
    private String frigories;
    private String soroll;


    public Nevera() {
    }

    public Nevera(Nevera target) {
        super(target);
        if (target != null) {
            this.frigories = target.frigories;
            this.soroll = target.soroll;
    }
        }
    

    @Override
    public Electrodomestic clone() {
        return new Nevera(this);
    }

 
}
