public class Rentadora extends Electrodomestic {
    
    private String revolucions;
    private String soroll;
    
    public Rentadora() {
    }

    public Rentadora(Rentadora target) {
        super(target);
        if (target != null) {
            this.revolucions = target.revolucions;
            this.soroll = target.soroll;
    }
        }
    

    @Override
    public Electrodomestic clone() {
        return new Rentadora(this);
    }

 
    
}
