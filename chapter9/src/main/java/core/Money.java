package core;

import java.util.Objects;

public abstract class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public abstract Money times(int amount);

    @Override
    public boolean equals(Object o) {

        if (o instanceof Money) {
            Money money = (Money) o;
            return money.amount == amount && this.getClass().equals(money.getClass());
        }

        return false;
    }

    public String currency() {
        return this.currency;
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
