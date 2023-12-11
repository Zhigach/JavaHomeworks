import static org.junit.jupiter.api.Assertions.*;

class BinarySearchEngineTest {

    @org.junit.jupiter.api.Test
    void binarySearchZeroPos() {
        int[] array = {0, 1, 2, 4, 6, 7, 9, 15};
        assertEquals(0, BinarySearchEngine.binarySearch(array, 0));
    }

    @org.junit.jupiter.api.Test
    void binarySearchLastPos() {
        int[] array = {0, 1, 2, 4, 6, 7, 9, 15};
        assertEquals(array.length - 1, BinarySearchEngine.binarySearch(array, 15));
    }

    @org.junit.jupiter.api.Test
    void binarySearchNoMatching() {
        int[] array = {0, 1, 2, 4, 6, 7, 9, 15};
        assertEquals(-1, BinarySearchEngine.binarySearch(array, 155151));
    }

    @org.junit.jupiter.api.Test
    void binarySearchMiddlePos() {
        int[] array = {0, 1, 1, 4, 6, 7, 9, 15};
        assertEquals(4, BinarySearchEngine.binarySearch(array, 6));
    }

    @org.junit.jupiter.api.Test
    void binarySearchException() {
        int[] array = {0, 1, 2, 4, 6, -5, 9, 15};
        assertThrows(IllegalArgumentException.class, () -> BinarySearchEngine.binarySearch(array, -2));
    }
}