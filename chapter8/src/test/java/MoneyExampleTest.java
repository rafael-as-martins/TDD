import core.Dollar;
import core.Franc;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyExampleTest {

    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);

        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }

    @Test
    public void testDollarEqualityOf5And5(){
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
    }

    @Test
    public void testDollarEqualityOf5And6(){
        assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
    }

    @Test
    public void testMoneyEquality(){
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(6)).isEqualTo(new Dollar(6));

        assertThat(new Franc(5)).isEqualTo(new Franc(5));
        assertThat(new Franc(6)).isEqualTo(new Franc(6));

        assertThat(new Franc(6)).isNotEqualTo(new Dollar(6));
    }

    @Test
    public void testFrancMultiplication10Times2And15Times3(){
        Franc five = new Franc(5);

        assertThat(five.times(2)).isEqualTo(new Franc(10));
        assertThat(five.times(3)).isEqualTo(new Franc(15));
    }

}
