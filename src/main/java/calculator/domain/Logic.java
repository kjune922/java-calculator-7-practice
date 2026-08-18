package calculator.domain;

import calculator.validator.InputValidator;

public class Logic {

    public int inputToNum(String input) {
        InputValidator inputValidator = new InputValidator();
        return inputValidator.validateInput(input);
    }

}
