import java.util.Arrays;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC20 Defensive Search Tests ---");

        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();

        System.out.println("\nAll tests completed.");
    }

    public static void testSearch_ThrowsExceptionWhenEmpty() {
        String[] dataset = {};
        try {
            executeSearch(dataset, "BG101");
            printResult("testSearch_ThrowsExceptionWhenEmpty", false);
        } catch (IllegalStateException e) {
            printResult("testSearch_ThrowsExceptionWhenEmpty", true);
        }
    }

    public static void testSearch_AllowsSearchWhenDataExists() {
        String[] dataset = {"BG101", "BG205"};
        try {
            executeSearch(dataset, "BG101");
            printResult("testSearch_AllowsSearchWhenDataExists", true);
        } catch (IllegalStateException e) {
            printResult("testSearch_AllowsSearchWhenDataExists", false);
        }
    }

    public static void testSearch_BogieFoundAfterValidation() {
        String[] dataset = {"BG101", "BG205", "BG309"};
        boolean result = executeSearch(dataset, "BG205");
        printResult("testSearch_BogieFoundAfterValidation", result);
    }

    public static void testSearch_BogieNotFoundAfterValidation() {
        String[] dataset = {"BG101", "BG205", "BG309"};
        boolean result = executeSearch(dataset, "BG999");
        printResult("testSearch_BogieNotFoundAfterValidation", !result);
    }

    public static void testSearch_SingleElementValidCase() {
        String[] dataset = {"BG101"};
        boolean result = executeSearch(dataset, "BG101");
        printResult("testSearch_SingleElementValidCase", result);
    }

    // executeSearch implementation for testing
    private static boolean executeSearch(String[] arr, String key) {
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("Empty");
        }
        return Arrays.binarySearch(arr, key) >= 0;
    }

    private static void printResult(String testName, boolean success) {
        System.out.println((success ? "[PASS] " : "[FAIL] ") + testName);
    }
}
