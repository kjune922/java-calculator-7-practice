package calculator.controller;

import calculator.domain.Calculator;
import calculator.parser.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Calculator calculator = new Calculator();
    private final InputParser inputParser = new InputParser();

    public void start() {
        outputView.firstMessage();
        String input = inputView.readInput();
        List<Integer> numList = inputParser.parse(input);
        int result = calculator.calculateSum(numList);
        outputView.printResult(result);
    }
}
