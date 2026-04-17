public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC18 Linear Search Tests ---");

        testSearch_BogieFound();
        testSearch_BogieNotFound();
        testSearch_FirstElementMatch();
        testSearch_LastElementMatch();
        testSearch_SingleElementArray();

        System.out.println("\nAll tests completed.");
    }

    public static void testSearch_BogieFound() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = linearSearch(dataset, "BG309");
        printResult("testSearch_BogieFound", result, true);
    }

    public static void testSearch_BogieNotFound() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = linearSearch(dataset, "BG999");
        printResult("testSearch_BogieNotFound", result, false);
    }

    public static void testSearch_FirstElementMatch() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = linearSearch(dataset, "BG101");
        printResult("testSearch_FirstElementMatch", result, true);
    }

    public static void testSearch_LastElementMatch() {
        String[] dataset = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = linearSearch(dataset, "BG550");
        printResult("testSearch_LastElementMatch", result, true);
    }

    public static void testSearch_SingleElementArray() {
        String[] dataset = {"BG101"};
        boolean result = linearSearch(dataset, "BG101");
        printResult("testSearch_SingleElementArray", result, true);
    }

    // Linear Search implementation for testing
    private static boolean linearSearch(String[] arr, String key) {
        for (String s : arr) {
            if (s.equals(key)) return true;
        }
        return false;
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        System.out.println((actual == expected ? "[PASS] " : "[FAIL] ") + testName);
    }
}
