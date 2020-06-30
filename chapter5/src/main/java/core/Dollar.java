package core;

import java.util.Objects;

public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {

        if(o instanceof  Dollar){
            Dollar dollar = (Dollar) o;
            return dollar.amount == amount;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
