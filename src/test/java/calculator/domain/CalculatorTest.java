package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 숫자_목록들의_합을_계산() {
        int result = calculator.calculateSum(List.of(1,2,3));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빈_목록의_합은_0이다() {
        int result = calculator.calculateSum(List.of());
        assertThat(result).isEqualTo(0);
    }

}