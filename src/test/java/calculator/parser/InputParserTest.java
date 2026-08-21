package calculator.parser;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    private InputParser inputParser = new InputParser();
    private Calculator calculator = new Calculator();

    @Test
    void 빈_문자열은_비어있는_숫자목록을_반환() {
        List<Integer> numbers = inputParser.parse("");
        assertThat(numbers).isEmpty();
    }

    @Test
    void _12가_입력으로들어오면_3이아닌_12() {
        String input = "12";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(12);
    }

    @Test
    void 기본구분자만으로도_숫자를_분리한다() {
        String input = "1,2,:3";
        List<Integer> numbers = inputParser.parse(input);
        assertThat(numbers).containsExactly(1,2,3);
    }

    @Test
    void 기본구분자가_연속이어도_계산가능() {
        String input = "1,,2";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(3);
    }

    @Test
    void 여러_글자의_커스텀_구분자를_사용할수있다() {
        String input = "//;;\\n1;;2;;3";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_연속이어도_계산가능() {
        String input = "//;\\n1;;2;;;3";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(6);
    }

    @Test
    void 선언한_커스텀_구분자와_다른_문자를_사용하면_예외발생() {
        String input = "//;!\\n1!2;!3";
        assertThatThrownBy(() -> inputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_구분자와_커스텀_구분자를_함께_사용가능() {
        String input = "//;\\n1;2,3:4";
        assertThat(calculator.calculateSum(inputParser.parse(input)))
                .isEqualTo(10);
    }

    @Test
    void 마지막_문자가_구분자면_예외발생() {
        String input = "1,2,";
        assertThatThrownBy(() -> inputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}