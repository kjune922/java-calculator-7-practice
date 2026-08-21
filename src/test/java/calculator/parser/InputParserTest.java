package calculator.parser;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    private InputParser inputParser = new InputParser();
    private Calculator calculator = new Calculator();

    @Test
    void 빈_문자열은_0을반환() {
        String input = "";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(0);
    }

    @Test
    void _12가_입력으로들어오면_3이아닌_12() {
        String input = "12";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(12);
    }

    @Test
    void 기본구분자만으로_계산가능() {
        String input = "1,2,:3";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(6);
    }

    @Test
    void 기본구분자가_연속이어도_계산가능() {
        String input = "1,,2";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(3);
    }

    @Test
    void 커스텀_구분자가_여러_글자여도_가능() {
        String input = "//;\\n1;;2;;;3";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(6);
    }

    @Test
    void 잘못된_커스텀_구분자는_예외를_반환() {
        String input = "//;!\\n1!2;!3";
        assertThatThrownBy(() -> inputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 마지막_문자가_구분자면_예외발생() {
        String input = "1,2,";
        assertThatThrownBy(() -> inputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}