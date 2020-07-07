import core.Bank;
import core.Expression;
import core.Money;
import core.Sum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyExampleTest {

    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);

        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testDollarEqualityOf5And5(){
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
    }

    @Test
    public void testDollarEqualityOf5And6(){
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
    }

    @Test
    public void testMoneyEquality(){
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(6)).isNotEqualTo(Money.dollar(6));
    }

    @Test
    public void testCurrencyUSDAndCHF(){
        assertThat("USD").isEqualTo(Money.dollar(5).currency());
        assertThat("CHF").isEqualTo(Money.franc(5).currency());
    }

    @Test
    public void testSimpleAddition5DollarWith5Dollar(){

        Expression sum = Money.dollar(3).plus(Money.dollar(4));

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");

        assertThat(Money.dollar(7)).isEqualTo(reduced);
        assertThat("USD").isEqualTo(reduced.getCurrency());
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(Money.dollar(1)).isEqualTo(result);

    }

    @Test
    public void testIdentityRate(){
        assertThat(1).isEqualTo(new Bank().rate("USD", "USD"));
    }

}
