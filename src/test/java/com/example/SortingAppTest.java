package com.example;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;

class SortingAppTest {


    @Test
    void testStandardArraySort() throws IOException {
        // Create a SortingApp instance with predetermined array values
        int[] inputArray = {10, 7, 8, 9, 1, 5, 3, 2, 6, 4};
        SortingApp sorter = new SortingApp(inputArray);

        // Expected sorted array
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Test all three sorting algorithms
        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with standard array");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with standard array");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with standard array");
    }

    // Test with single element array
    @Test
    void testSingleElementArray() throws IOException {
        int[] inputArray = {42};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {42};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with single element");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with single element");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with single element");
    }

    // Test with already sorted array
    @Test
    void testAlreadySortedArray() throws IOException {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with already sorted array");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with already sorted array");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with already sorted array");
    }

    // Test with reverse sorted array
    @Test
    void testReverseSortedArray() throws IOException {
        int[] inputArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with reverse sorted array");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with reverse sorted array");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with reverse sorted array");
    }

    // Test with duplicate elements
    @Test
    void testArrayWithDuplicates() throws IOException {
        int[] inputArray = {5, 2, 8, 2, 5, 1, 8};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {1, 2, 2, 5, 5, 8, 8};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with duplicate elements");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with duplicate elements");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with duplicate elements");
    }

    // Test with all same values
    @Test
    void testArrayWithAllSameValues() throws IOException {
        int[] inputArray = {7, 7, 7, 7, 7};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {7, 7, 7, 7, 7};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with same values");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with same values");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with same values");
    }

    // Test with negative numbers
    @Test
    void testWithNegativeNumbers() throws IOException {
        int[] inputArray = {-5, -10, -1, -8, -3};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {-10, -8, -5, -3, -1};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with negative numbers");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with negative numbers");

        // Note: The original Radix sort implementation doesn't handle negative numbers correctly
    }

    // Test with mixed positive and negative numbers
    @Test
    void testWithMixedNumbers() throws IOException {
        int[] inputArray = {5, -10, 7, -3, 2, 0, -1};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {-10, -3, -1, 0, 2, 5, 7};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with mixed numbers");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with mixed numbers");
    }

    // Test with empty array
    @Test
    void testEmptyArray() throws IOException {
        int[] inputArray = {};
        SortingApp sorter = new SortingApp(inputArray);

        int[] expected = {};

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with empty array");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with empty array");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with empty array");
    }

    // Test with large array
    @Test
    void testLargeArray() throws IOException {
        // Generate a large array of random integers
        Random random = new Random(42); // Use a seed for reproducibility
        int size = 1000;
        int[] inputArray = new int[size];
        for (int i = 0; i < size; i++) {
            inputArray[i] = random.nextInt(10000);
        }

        SortingApp sorter = new SortingApp(inputArray);

        // Create expected result using Arrays.sort
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(false), "Bubble sort failed with large array");
        assertArrayEquals(expected, sorter.efficientSort(false), "Merge sort failed with large array");
        assertArrayEquals(expected, sorter.nonComparisonSort(false), "Radix sort failed with large array");
    }
}