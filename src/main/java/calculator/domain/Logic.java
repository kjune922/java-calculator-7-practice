package calculator.domain;

import calculator.parser.InputParser;
import java.util.List;

public class Logic {

    private final InputParser inputParser = new InputParser();

    public int inputToNum(String input) {
        List<Integer> numList = inputParser.parse(input);
        int sum = 0;
        for (Integer i : numList) {
            sum += i;
        }
        return sum;
    }

}
