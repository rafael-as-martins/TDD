package core;

public class Franc extends Money{


    public Franc(int amount) {
        super(amount);
    }

    public Money times(int amount) {
        return new Franc(amount * this.amount);
    }
}
