import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayTest {

    IntArray arr0 = new IntArray(new int[]{-1, 0, -2, 2, 1});
    IntArray arrPos = new IntArray(new int[]{1, 2, 3, 4, 5});
    IntArray arrNeg = new IntArray(new int[]{-2, -4, -6, 0});
    IntArray emptyArr = new IntArray(new int[]{});

    @Test
    void getAverageZero() {
        assertEquals(0, arr0.getAverage());
    }
    @Test
    void getAveragePositive() {
        //3
        assertEquals(3, arrPos.getAverage());
    }
    @Test
    void getAverageNegative() {
        assertEquals(-3, arrNeg.getAverage());
    }
    @Test
    void getAverageEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> emptyArr.getAverage());
    }


}