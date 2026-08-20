package calculator.controller;

import calculator.domain.Logic;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final OutputView outputView = new OutputView();
    private final InputView inputParser = new InputView();
    private final Logic logic = new Logic();

    public void start() {
        outputView.firstMessage();
        String input = inputParser.readInput();
        outputView.readCustom(logic.inputToNum(input));
    }
}
