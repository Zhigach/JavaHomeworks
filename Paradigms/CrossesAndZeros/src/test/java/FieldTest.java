import static org.junit.Assert.assertTrue;

class FieldTest {
    static Field field;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        field = new Field();
    }

    @org.junit.jupiter.api.Test
    void print() {
        field.print();
    }

    @org.junit.jupiter.api.Test
    void hasFinishedRow() {
        field.setValue(0, Symbol.CROSS);
        field.setValue(4, Symbol.CROSS);
        field.setValue(8, Symbol.CROSS);
        field.print();
        assertTrue(field.hasFinishedRow(Symbol.EMPTY));
    }
}