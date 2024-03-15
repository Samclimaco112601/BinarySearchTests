package Search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

/**
 * @author samclimaco
 * @version spring 2024
 * file that tests the binary search file
 */

class BinarySearchTest {

    @Test
    void testWithTargetInArray() {
        int[] array = {1, 3, 5, 7, 9};
        int target = 5;
        assertEquals(2, BinarySearch.binarySearch(array, target), "Target found at the correct index.");
    }

    @Test
    void testWithTargetNotInArray() {
        int[] array = {1, 2, 4, 6, 8};
        int target = 5;
        assertEquals(-1, BinarySearch.binarySearch(array, target), "Target not in array should return -1.");
    }

    @Test
    void testAtExtremeIndices() {
        int[] array = {0, 10, 20, 30, 40, 50};
        assertEquals(0, BinarySearch.binarySearch(array, 0), "Target is the first element.");
        assertEquals(5, BinarySearch.binarySearch(array, 50), "Target is the last element.");
    }

    @Test
    void testWithEmptyArray() {
        int[] array = {};
        int target = 1;
        assertEquals(-1, BinarySearch.binarySearch(array, target), "Empty array should return -1.");
    }

    @Test
    void testWithSingleElementArray() {
        int[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5), "Single-element array containing the target should return index 0.");
        assertEquals(-1, BinarySearch.binarySearch(array, 3), "Single-element array not containing the target should return -1.");
    }

    @Test
    void testWithLargeArray() {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
        int target = 999998;
        assertTrue(BinarySearch.binarySearch(array, target) > 0, "Target should be found in a large array.");
    }

    @Test
    void testRandomArrays() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int size = random.nextInt(200) + 1; // Avoid zero length
            int[] array = random.ints(size, 0, 1000).sorted().toArray();
            int targetIndex = random.nextInt(size);
            int target = array[targetIndex];

            assertEquals(targetIndex, BinarySearch.binarySearch(array, target), "Target should match the index in randomly generated array.");
        }
    }

    // A slower but correct algorithm
    private int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void compareWithLinearSearch() {
        Random random = new Random();
        int[] array = random.ints(100, -50, 50).sorted().toArray();
        int target = random.nextInt(100) - 50;

        assertEquals(linearSearch(array, target), BinarySearch.binarySearch(array, target), "Binary search should match linear search results.");
    }
}
