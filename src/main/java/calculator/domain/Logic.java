package calculator.domain;

import calculator.validator.InputValidator;

public class Logic {

    public int inputToNum(String input) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateInput(input);

        return 0;
    }

}
