package core;

public class Franc extends Money{


    public Franc(int amount, String currency) {
        super(amount, currency); 
    }

    public Money times(int amount) {
        return new Money(amount * this.amount, currency);
    }


}
