package calculator.domain;

import java.util.List;

public class Logic {

    public int CalculateNumList(List<Integer> numList) {
        int sum = 0;
        for (Integer i : numList) {
            sum += i;
        }
        return sum;
    }

}
