package calculator.controller;

import calculator.domain.Logic;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    public static void Start() {
        OutputView outputView = new OutputView();
        outputView.firstMessage();

        InputView inputView = new InputView();
        String input = inputView.readInput();

        Logic logic = new Logic();
        outputView.readCustom(logic.inputToNum(input));
    }
}
