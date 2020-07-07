import core.Bank;
import core.Expression;
import core.Money;
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

        Bank bank = new Bank();
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        Money reduced = bank.reduce(sum, "USD");

        assertThat(Money.dollar(10)).isEqualTo(reduced);
    }


}
