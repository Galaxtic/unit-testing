package Business;

import Data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

//    public int calculateSum(int[] data)
//    {
//
//        int sum = 0;
//        for(int val:data)
//            sum += val;
//        return sum;
//    }


    //As seen below, functional programming allows us to reduce the above code to a single line of code
    public int calculateSum(int[] data)
    {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService()
    {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int val:data)
            sum += val;
        return sum;
    }
}
