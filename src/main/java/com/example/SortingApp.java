package com.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.Math.log;

public class SortingApp {
    // ANSI escape codes for colors and bold text
    private static final String CYAN = "\u001B[36;1m";
    private static final String GREEN = "\u001B[32;1m";
    private static final String YELLOW = "\u001B[33;1m";
    private static final String RED = "\u001B[31;1m";
    private static final String BLUE = "\u001B[34;1m";
    private static final String RESET = "\u001B[0m";

    private int[] array;

    // Constructor: Reads integers from a file and initializes the array
    public SortingApp(int[] input) throws IOException {
        array = input;
    }

    // Bubble Sort (O(n²))
    public int[] simpleSort(boolean showSteps, Boolean calculateTime) {
        int[] arr = Arrays.copyOf(array, array.length);
        long startTime = 0;
        if (calculateTime) {
            startTime = System.nanoTime();
        }

        if (showSteps)
            System.out.println(YELLOW + "Bubble Sort Steps:" + RESET);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (showSteps)
                System.out.println(YELLOW + Arrays.toString(arr) + RESET);
        }
        if (calculateTime) {
            long endTime = System.nanoTime();
            double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;
            System.out.println("Bubble Sort execution time: " + elapsedTimeMs + " ms");
        }
        return arr;
    }

    // Merge Sort (O(n log n))
    public int[] efficientSort(boolean showSteps, Boolean calculateTime) {
        int[] arr = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();

        if (showSteps)
            System.out.println(YELLOW + "Merge Sort Steps:" + RESET);
        mergeSort(arr, 0, arr.length - 1, showSteps);


        if (calculateTime) {
            long endTime = System.nanoTime();
            double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;
            System.out.println("Merge Sort execution time: " + elapsedTimeMs + " ms");
        }
        return arr;
    }

    // radix Sort (O(n))
    public int[] nonComparisonSort(boolean showSteps, Boolean calculateTime) {
        int[] arr = Arrays.copyOf(array, array.length);
        long startTime = 0;
        if (calculateTime) {
            startTime = System.nanoTime();
        }

        if (showSteps)
            System.out.println(YELLOW + "radix Sort Steps:" + RESET);
        OptionalInt min = Arrays.stream(arr).min();
        if(min.isPresent() && min.getAsInt() > 0)
            radixSort(arr, showSteps);
        else if(min.isPresent()){
            System.out.println("Can't use radix sort with negative numbers");
        }

        if (calculateTime) {
            long endTime = System.nanoTime();
            double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;
            System.out.println("Radix Sort execution time: " + elapsedTimeMs + " ms");
        }
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right, boolean showSteps) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, showSteps);
            mergeSort(arr, mid + 1, right, showSteps);
            merge(arr, left, mid, right, showSteps);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, boolean showSteps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
        if (showSteps)
            System.out.println(YELLOW + Arrays.toString(arr) + RESET);
    }

    private void radixSort(int[] arr, Boolean showsteps){
        int base = arr.length, iterations, curBase = base;
        OptionalInt maxElement = Arrays.stream(arr).max();
        iterations = (int) (log(maxElement.getAsInt()) / log(base)) + 1;
        ArrayList<Integer>[] buckets;
        buckets = new ArrayList[base];
        for(int j = 0; j < base; ++j){
            buckets[j] = new ArrayList<>();
        }
        for(int i = 0; i < iterations; ++i){
            int[] newArr = Arrays.copyOf(arr, arr.length);
            for(int j = 0; j < arr.length; ++j){
                buckets[myMod(arr[j], curBase, base)].add(arr[j]);
            }
            for(int j = 0, idx = 0; j < base; ++j){
                for(int k : buckets[j]){
                    arr[idx++] = k;
                }
            }
            for(int j = 0; j < base; ++j){
                buckets[j].clear();
            }
            if(showsteps){
                for(int j : arr){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            curBase *= base;
        }
    }

    private Integer myMod(Integer a, Integer currBase, Integer base){
        int prevBase = currBase / base;
        return (a % currBase) / prevBase ;
    }

    private static int[] readNumbersFromFile(String filePath) throws IOException, NumberFormatException {
        String content = Files.readString(Path.of(filePath)).trim();
        if (content.isEmpty()) {
            throw new IOException("File is empty: " + filePath);
        }
        String[] parts = content.split(",\\s*");
        return Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
    }


    // Command-line interface for the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortingApp sorter;

        // Get file path from user
        System.out.print(CYAN + "Enter the path to the input file: " + RESET);
        String filePath = scanner.nextLine();

        try {
            int tmpArray[] = readNumbersFromFile(filePath);
            sorter = new SortingApp(tmpArray);
        } catch (IOException e) {
            System.out.println(RED + "Error reading file: " + e.getMessage() + RESET);
            scanner.close();
            return;
        }

        while (true) {
            System.out.println(BLUE + "\nSorting Menu:" + RESET);
            System.out.println("1. Simple Sort (O(n²))");
            System.out.println("2. Efficient Sort (O(n log n))");
            System.out.println("3. Non-Comparison Sort (O(n))");
            System.out.println("4. Exit");

            System.out.print(CYAN + "Choose an option: " + RESET);
            int choice = scanner.nextInt();

            if (choice == 4)
                break;

            System.out.print(CYAN + "Show intermediate steps? (true/false): " + RESET);
            boolean showSteps = scanner.nextBoolean();
            boolean calculateTime = false;

            int[] sortedArray = null;
            switch (choice) {
                case 1 -> sortedArray = sorter.simpleSort(showSteps,calculateTime);
                case 2 -> sortedArray = sorter.efficientSort(showSteps,calculateTime);
                case 3 -> sortedArray = sorter.nonComparisonSort(showSteps,calculateTime);
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }

            if (sortedArray != null)
                System.out.println(GREEN + "\nSorted Array: " + Arrays.toString(sortedArray) + RESET);
        }
        scanner.close();
    }
}
