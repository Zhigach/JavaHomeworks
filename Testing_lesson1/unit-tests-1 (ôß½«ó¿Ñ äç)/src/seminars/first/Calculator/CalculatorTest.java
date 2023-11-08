package seminars.first.Calculator;

import seminars.first.Calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:

        assertThat(Calculator.calculatingDiscount(100, 30)).isEqualTo(70);
        assertThat(Calculator.calculatingDiscount(50, 50)).isEqualTo(25);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 110)
        ).isInstanceOf(ArithmeticException.class);
    }
}