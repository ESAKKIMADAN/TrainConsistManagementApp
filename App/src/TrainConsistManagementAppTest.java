import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementAppTest {
    
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";
    private static final Pattern trainIdPattern = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern cargoCodePattern = Pattern.compile(CARGO_CODE_REGEX);

    public static void main(String[] args) {
        System.out.println("--- Running UC11 Regex Validation Tests ---");
        
        testRegex_ValidTrainID();
        testRegex_InvalidTrainIDFormat();
        testRegex_ValidCargoCode();
        testRegex_InvalidCargoCodeFormat();
        testRegex_TrainIDDigitLengthValidation();
        testRegex_CargoCodeUppercaseValidation();
        testRegex_EmptyInputHandling();
        testRegex_ExactPatternMatch();

        System.out.println("\nAll tests completed.");
    }

    public static void testRegex_ValidTrainID() {
        String input = "TRN-1234";
        boolean result = trainIdPattern.matcher(input).matches();
        printResult("testRegex_ValidTrainID", input, result, true);
    }

    public static void testRegex_InvalidTrainIDFormat() {
        String[] inputs = {"TRAIN12", "TRN12A", "1234-TRN"};
        for (String input : inputs) {
            boolean result = trainIdPattern.matcher(input).matches();
            printResult("testRegex_InvalidTrainIDFormat", input, result, false);
        }
    }

    public static void testRegex_ValidCargoCode() {
        String input = "PET-AB";
        boolean result = cargoCodePattern.matcher(input).matches();
        printResult("testRegex_ValidCargoCode", input, result, true);
    }

    public static void testRegex_InvalidCargoCodeFormat() {
        String[] inputs = {"PET123", "AB-PET"};
        for (String input : inputs) {
            boolean result = cargoCodePattern.matcher(input).matches();
            printResult("testRegex_InvalidCargoCodeFormat", input, result, false);
        }
    }

    public static void testRegex_TrainIDDigitLengthValidation() {
        String[] inputs = {"TRN-123", "TRN-12345"};
        for (String input : inputs) {
            boolean result = trainIdPattern.matcher(input).matches();
            printResult("testRegex_TrainIDDigitLengthValidation", input, result, false);
        }
    }

    public static void testRegex_CargoCodeUppercaseValidation() {
        String input = "PET-ab";
        boolean result = cargoCodePattern.matcher(input).matches();
        printResult("testRegex_CargoCodeUppercaseValidation", input, result, false);
    }

    public static void testRegex_EmptyInputHandling() {
        String input = "";
        boolean trainResult = trainIdPattern.matcher(input).matches();
        boolean cargoResult = cargoCodePattern.matcher(input).matches();
        printResult("testRegex_EmptyInputHandling (Train)", input, trainResult, false);
        printResult("testRegex_EmptyInputHandling (Cargo)", input, cargoResult, false);
    }

    public static void testRegex_ExactPatternMatch() {
        String input = "TRN-1234EXTRA";
        boolean result = trainIdPattern.matcher(input).matches();
        printResult("testRegex_ExactPatternMatch", input, result, false);
    }

    private static void printResult(String testName, String input, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("[PASS] " + testName + " | Input: '" + input + "'");
        } else {
            System.out.println("[FAIL] " + testName + " | Input: '" + input + "' | Expected: " + expected + " | Actual: " + actual);
        }
    }
}
