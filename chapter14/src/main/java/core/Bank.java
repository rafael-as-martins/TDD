package core;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Pair, Integer> rates;

    public Bank(){
        rates = new HashMap<>();
    }

    public Money reduce(Expression expression, String toCurrency) {
        return expression.reduce(this, toCurrency);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        return rates.getOrDefault(new Pair(from, to), (from.equals(to)? 1 : null));
    }
}
