import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void initializeNewCalc() {
        calculator = new Calculator();
    }

    @AfterEach
    public void destroyNewCalc() {
        calculator = null;
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка четного числа")
    void evenOddNumberEven() {
        assertTrue(calculator.evenOddNumber(4));
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Проверка нечетного числа")
    void evenOddNumberOdd() {
        assertFalse(calculator.evenOddNumber(5));
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Проверка корректного поведения для 0")
    void evenOddNumberZero() {
        assertTrue(calculator.evenOddNumber(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    public void numberIntervalTrue(int value) {
        assertTrue(calculator.numberInInterval(value));
    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 25, 100, 106})
    public void numberIntervalFalse(int value) {
        assertFalse(calculator.numberInInterval(value));
    }
}