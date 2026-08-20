package calculator.controller;

import calculator.domain.Logic;
import calculator.parser.InputParser;
import calculator.view.OutputView;

public class CalculatorController {

    private final OutputView outputView = new OutputView();
    private final InputParser inputParser = new InputParser();
    private final Logic logic = new Logic();

    public void start() {
        outputView.firstMessage();
        String input = inputParser.parseInput();
        outputView.readCustom(logic.inputToNum(input));
    }
}
