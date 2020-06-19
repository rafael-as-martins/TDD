import core.Dollar;
import org.junit.Assert;
import org.junit.Test;

public class MoneyExampleTest {

    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);

        five.times(2);

        Assert.assertEquals(10, five.amout);

    }

}
