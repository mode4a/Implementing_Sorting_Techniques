import java.io.*;
import java.util.*;

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
    public SortingApp(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String[] values = line.split(",");
            for (String value : values) {
                numbers.add(Integer.parseInt(value.trim()));
            }
        }
        array = numbers.stream().mapToInt(i -> i).toArray();
    }

    // Bubble Sort (O(n²))
    public int[] simpleSort(boolean showSteps) {
        int[] arr = Arrays.copyOf(array, array.length);
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
        return arr;
    }

    // Merge Sort (O(n log n))
    public int[] efficientSort(boolean showSteps) {
        int[] arr = Arrays.copyOf(array, array.length);
        if (showSteps)
            System.out.println(YELLOW + "Merge Sort Steps:" + RESET);
        mergeSort(arr, 0, arr.length - 1, showSteps);
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

    // Counting Sort (O(n))
    public int[] nonComparisonSort(boolean showSteps) {
        int[] arr = Arrays.copyOf(array, array.length);
        if (showSteps)
            System.out.println(YELLOW + "Counting Sort Steps:" + RESET);
        return arr;
    }

    // Command-line interface for the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortingApp sorter;

        // Get file path from user
        System.out.print(CYAN + "Enter the path to the input file: " + RESET);
        String filePath = scanner.nextLine();

        try {
            sorter = new SortingApp(filePath);
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

            int[] sortedArray = null;
            switch (choice) {
                case 1 -> sortedArray = sorter.simpleSort(showSteps);
                case 2 -> sortedArray = sorter.efficientSort(showSteps);
                case 3 -> sortedArray = sorter.nonComparisonSort(showSteps);
                default -> System.out.println(RED + "Invalid choice!" + RESET);
            }

            if (sortedArray != null)
                System.out.println(GREEN + "\nSorted Array: " + Arrays.toString(sortedArray) + RESET);
        }
        scanner.close();
    }
}
