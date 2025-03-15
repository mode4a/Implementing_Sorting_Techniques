package com.example;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;

class SortingAppTest {
    private Random random = new Random(42); 
    Boolean showSteps = false;
    Boolean calculateTime = false;

    @Test
    void testSortedArray10() throws IOException {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with sorted array (size 10)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with sorted array (size 10)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with sorted array (size 10)");
    }

    @Test
    void testReversedArray10() throws IOException {
        int[] inputArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with reversed array (size 10)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with reversed array (size 10)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with reversed array (size 10)");
    }

    @Test
    void testUnorderedArray10() throws IOException {
        int[] inputArray = {7, 2, 9, 4, 1, 8, 5, 10, 3, 6};
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with unordered array (size 10)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with unordered array (size 10)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with unordered array (size 10)");
    }

    @Test
    void testNegativeArray10() throws IOException {
        int[] inputArray = {-5, -2, -9, -7, -1, -8, -4, -3, -6, -10};
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1};

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 10)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 10)");
        //assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 10)");
    }

    @Test
    void testMixedArray10() throws IOException {
        int[] inputArray = {-5, 2, -9, 7, -1, 8, -4, 3, -6, 10};
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = {-9, -6, -5, -4, -1, 2, 3, 7, 8, 10};

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 10)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 10)");
        //assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 10)");
    }

    @Test
    void testSortedArray50() throws IOException {
        int[] inputArray = new int[50];
        for (int i = 0; i < 50; i++) {
            inputArray[i] = i + 1;
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with sorted array (size 50)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with sorted array (size 50)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with sorted array (size 50)");
    }

    @Test
    void testReversedArray50() throws IOException {
        int[] inputArray = new int[50];
        for (int i = 0; i < 50; i++) {
            inputArray[i] = 50 - i;
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = new int[50];
        for (int i = 0; i < 50; i++) {
            expected[i] = i + 1;
        }

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with reversed array (size 50)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with reversed array (size 50)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with reversed array (size 50)");
    }

    @Test
    void testRandomArray50() throws IOException {
        int[] inputArray = new int[50];
        for (int i = 0; i < 50; i++) {
            inputArray[i] = random.nextInt(1000);
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random array (size 50)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 50)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 50)");
    }

    @Test
    void testRandomMixedArray50() throws IOException {
        int[] inputArray = new int[50];
        for (int i = 0; i < 50; i++) {
            inputArray[i] = random.nextInt(1000) - 500; // Range [-500, 499]
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 50)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 50)");
        //assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 50)");
    }

    @Test
    void testSortedArray100() throws IOException {
        int[] inputArray = new int[100];
        for (int i = 0; i < 100; i++) {
            inputArray[i] = i + 1;
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with sorted array (size 100)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with sorted array (size 100)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with sorted array (size 100)");
    }

    @Test
    void testReversedArray100() throws IOException {
        int[] inputArray = new int[100];
        for (int i = 0; i < 100; i++) {
            inputArray[i] = 100 - i;
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = i + 1;
        }

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with reversed array (size 100)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with reversed array (size 100)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with reversed array (size 100)");
    }

    @Test
    void testRandomArray100() throws IOException {
        int[] inputArray = new int[100];
        for (int i = 0; i < 100; i++) {
            inputArray[i] = random.nextInt(10000);
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random array (size 100)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 100)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 100)");
    }

    @Test
    void testRandomMixedArray100() throws IOException {
        int[] inputArray = new int[100];
        for (int i = 0; i < 100; i++) {
            inputArray[i] = random.nextInt(10000) - 5000; // Range [-5000, 4999]
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 100)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 100)");
        //assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 100)");
    }

    @Test
    void testRandomArray1000() throws IOException {
        int[] inputArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            inputArray[i] = random.nextInt(10000);
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 100)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 100)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 100)");
    }

    @Test
    void testRandomArray2500() throws IOException {
        int[] inputArray = new int[2500];
        for (int i = 0; i < 2500; i++) {
            inputArray[i] = random.nextInt(10000);
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 2500)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 2500)");
        assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 2500)");
    }

    @Test
    void testRandomMixedArray2500() throws IOException {
        int[] inputArray = new int[2500];
        for (int i = 0; i < 2500; i++) {
            inputArray[i] = random.nextInt(10000) - 5000; // Range [-5000, 4999]
        }
        SortingApp sorter = new SortingApp(inputArray);
        int[] expected = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(expected);

        assertArrayEquals(expected, sorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with random mixed array (size 2500)");
        assertArrayEquals(expected, sorter.efficientSort(showSteps, calculateTime), "Merge sort failed with random array (size 2500)");
        //assertArrayEquals(expected, sorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with random array (size 2500)");
    }

    @Test
    void testEdgeCases() throws IOException {
        // Empty array
        int[] emptyArray = {};
        SortingApp emptySorter = new SortingApp(emptyArray);
        assertArrayEquals(emptyArray, emptySorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with empty array");
        assertArrayEquals(emptyArray, emptySorter.efficientSort(showSteps, calculateTime), "Merge sort failed with empty array");
        assertArrayEquals(emptyArray, emptySorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with empty array");

        // Single element array
        int[] singleArray = {42};
        SortingApp singleSorter = new SortingApp(singleArray);
        assertArrayEquals(singleArray, singleSorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with single element array");
        assertArrayEquals(singleArray, singleSorter.efficientSort(showSteps, calculateTime), "Merge sort failed with single element array");
        assertArrayEquals(singleArray, singleSorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with single element array");

        // Duplicate elements
        int[] duplicateArray = {5, 2, 8, 2, 5, 1, 8};
        SortingApp duplicateSorter = new SortingApp(duplicateArray);
        int[] expected = {1, 2, 2, 5, 5, 8, 8};
        assertArrayEquals(expected, duplicateSorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with duplicate elements");
        assertArrayEquals(expected, duplicateSorter.efficientSort(showSteps, calculateTime), "Merge sort failed with duplicate elements");
        assertArrayEquals(expected, duplicateSorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with duplicate elements");
        
        // All same values
        int[] sameArray = {7, 7, 7, 7, 7};
        SortingApp sameSorter = new SortingApp(sameArray);
        assertArrayEquals(sameArray, sameSorter.simpleSort(showSteps, calculateTime), "Bubble sort failed with all same values");
        assertArrayEquals(sameArray, sameSorter.efficientSort(showSteps, calculateTime), "Merge sort failed with all same values");
        assertArrayEquals(sameArray, sameSorter.nonComparisonSort(showSteps, calculateTime), "Radix sort failed with all same values");
    }
    
}