package core;

import java.util.Objects;

public class Money {

    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Money) {
            Money money = (Money) o;
            return money.amount == amount && this.getClass().equals(money.getClass());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
