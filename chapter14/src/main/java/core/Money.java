package core;

import java.util.Objects;

public class Money implements Expression{

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public Money times(int multiplier){
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public String toString() {
        return this.amount + " " + this.currency;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Money) {
            Money money = (Money) o;
            return money.amount == amount && this.currency.equals(money.currency);
        }

        return false;
    }

    @Override
    public Money reduce(Bank bank, String toCurrency){

        int rate = bank.rate(this.currency, toCurrency);

        return new Money(this.amount / rate ,toCurrency);
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

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
