import java.util.Arrays;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC17 Alphabetical Sorting Tests ---");

        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();

        System.out.println("\nAll tests completed.");
    }

    public static void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        printResult("testSort_BasicAlphabeticalSorting", Arrays.equals(input, expected));
    }

    public static void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        Arrays.sort(input);
        printResult("testSort_UnsortedInput", Arrays.equals(input, expected));
    }

    public static void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        Arrays.sort(input);
        printResult("testSort_AlreadySortedArray", Arrays.equals(input, expected));
    }

    public static void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        Arrays.sort(input);
        printResult("testSort_DuplicateBogieNames", Arrays.equals(input, expected));
    }

    public static void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        Arrays.sort(input);
        printResult("testSort_SingleElementArray", Arrays.equals(input, expected));
    }

    private static void printResult(String testName, boolean success) {
        System.out.println((success ? "[PASS] " : "[FAIL] ") + testName);
    }
}
