package task1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1Test {

    @BeforeEach
    public void setup() {
        // Initialize resources (environment)
    }

    @AfterEach
    public void teardown() {
        // Clear resources
    }

    @BeforeAll
    public static void globalSetup() {
        // Initialize once before testing
    }

    @Test
    public void testMethod() {
        assertEquals(5, 3 + 2);
    }

    @Test
    @DisplayName("Summ test")
    public void testSum() {
        assertEquals(5, 3 + 2);
    }

    @Test
    @DisplayName("Sample test")
    @Disabled
    public void testSum2() {
        assertEquals(5, 3 + 2);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void parametrizedTestMethod(int argument) {
        assertTrue(argument > 1);
    }

    @AfterAll
    public static void globalTearDown() {
        // Single cleanup after all tests
    }
}
