package core;

public interface Expression {

    Money reduce(Bank bank, String toCurrency);
}
