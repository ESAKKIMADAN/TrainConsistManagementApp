import java.util.Arrays;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC16 Bubble Sort Tests ---");

        testSort_BasicSorting();
        testSort_AlreadySortedArray();
        testSort_DuplicateValues();
        testSort_SingleElementArray();
        testSort_AllEqualValues();

        System.out.println("\nAll tests completed.");
    }

    public static void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        printResult("testSort_BasicSorting", Arrays.equals(input, expected));
    }

    public static void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        bubbleSort(input);
        printResult("testSort_AlreadySortedArray", Arrays.equals(input, expected));
    }

    public static void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        bubbleSort(input);
        printResult("testSort_DuplicateValues", Arrays.equals(input, expected));
    }

    public static void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        bubbleSort(input);
        printResult("testSort_SingleElementArray", Arrays.equals(input, expected));
    }

    public static void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        bubbleSort(input);
        printResult("testSort_AllEqualValues", Arrays.equals(input, expected));
    }

    // Manual Bubble Sort implementation for testing
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void printResult(String testName, boolean success) {
        System.out.println((success ? "[PASS] " : "[FAIL] ") + testName);
    }
}
