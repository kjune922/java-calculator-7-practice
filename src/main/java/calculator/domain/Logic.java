package calculator.domain;

import calculator.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public int inputToNum(String input) {
        InputValidator inputValidator = new InputValidator();
        return inputValidator.validateInput(input);
    }

}
