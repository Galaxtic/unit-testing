package Business;

import Data.SomeDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}
public class SomeBusinessStubTest {
    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualresult = business.calculateSumUsingDataService();
        int expectedresult = 6;

        Assertions.assertEquals(expectedresult, actualresult);

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualresult = business.calculateSumUsingDataService();
        int expectedresult = 0;

        Assertions.assertEquals(expectedresult, actualresult);

    }
}
