package core;

public interface Expression {

    Money reduce(Bank bank, String toCurrency);

    Expression plus(Expression money);

    Expression times(int multiplier);
}
