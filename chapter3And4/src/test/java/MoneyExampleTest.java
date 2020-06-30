import core.Dollar;
import org.assertj.core.api.Assertions;
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
    public void testEqualityOf5And5(){
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
    }

    @Test
    public void testEqualityOf5And6(){
        assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
    }

}
