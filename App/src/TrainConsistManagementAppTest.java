import java.util.Arrays;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC19 Binary Search Tests ---");

        testBinarySearch_BogieFound();
        testBinarySearch_BogieNotFound();
        testBinarySearch_FirstElementMatch();
        testBinarySearch_LastElementMatch();
        testBinarySearch_SingleElementArray();
        testBinarySearch_EmptyArray();
        testBinarySearch_UnsortedInputHandled();

        System.out.println("\nAll tests completed.");
    }

    public static void testBinarySearch_BogieFound() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = binarySearch(dataset, "BG309");
        printResult("testBinarySearch_BogieFound", result, true);
    }

    public static void testBinarySearch_BogieNotFound() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = binarySearch(dataset, "BG999");
        printResult("testBinarySearch_BogieNotFound", result, false);
    }

    public static void testBinarySearch_FirstElementMatch() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = binarySearch(dataset, "BG101");
        printResult("testBinarySearch_FirstElementMatch", result, true);
    }

    public static void testBinarySearch_LastElementMatch() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = binarySearch(dataset, "BG550");
        printResult("testBinarySearch_LastElementMatch", result, true);
    }

    public static void testBinarySearch_SingleElementArray() {
        String[] dataset = {"BG101"};
        boolean result = binarySearch(dataset, "BG101");
        printResult("testBinarySearch_SingleElementArray", result, true);
    }

    public static void testBinarySearch_EmptyArray() {
        String[] dataset = {};
        boolean result = binarySearch(dataset, "BG101");
        printResult("testBinarySearch_EmptyArray", result, false);
    }

    public static void testBinarySearch_UnsortedInputHandled() {
        String[] dataset = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        // Pre-sort before searching
        Arrays.sort(dataset);
        boolean result = binarySearch(dataset, "BG205");
        printResult("testBinarySearch_UnsortedInputHandled", result, true);
    }

    // Binary Search implementation for testing
    private static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = arr[mid].compareTo(key);
            if (comparison == 0) return true;
            else if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        System.out.println((actual == expected ? "[PASS] " : "[FAIL] ") + testName);
    }
}
