import core.Dollar;
import core.Franc;
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
        assertThat(Money.dollar(6)).isEqualTo(Money.dollar(6));

        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(6)).isEqualTo(Money.franc(6));

        assertThat(Money.franc(6)).isNotEqualTo(Money.dollar(6));
    }

    @Test
    public void testFrancMultiplication10Times2And15Times3(){
        Money five = Money.franc(5);

        assertThat(five.times(2)).isEqualTo(Money.franc(10));
        assertThat(five.times(3)).isEqualTo(Money.franc(15));
    }

    @Test
    public void testCurrencyUSDAndCHF(){
        assertThat("USD").isEqualTo(Money.dollar(5).currency());
        assertThat("CHF").isEqualTo(Money.franc(5).currency());
    }

    @Test
    public void testEqualityMoney5AndFranc5(){
        assertThat(new Money(5, "CHF")).isEqualTo(new Money(5, "CHF"));
    }

}
