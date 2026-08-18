package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    public static void Start() {
        OutputView outputView = new OutputView();
        outputView.firstMessage();

        InputView inputView = new InputView();
        inputView.readInput();
    }
}
