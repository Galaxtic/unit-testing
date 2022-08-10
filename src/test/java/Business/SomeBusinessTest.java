package Business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SomeBusinessTest {
    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualresult = business.calculateSum(new int[] {1,2,3});
        int expectedresult = 6;

        Assertions.assertEquals(actualresult, expectedresult);

    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualresult = business.calculateSum(new int[] {});
        int expectedresult = 0;

        Assertions.assertEquals(actualresult, expectedresult);

    }
}
