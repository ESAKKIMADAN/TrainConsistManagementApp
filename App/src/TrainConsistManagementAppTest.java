public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC14 Exception Validation Tests ---");

        testException_ValidCapacityCreation();
        testException_NegativeCapacityThrowsException();
        testException_ZeroCapacityThrowsException();
        testException_ExceptionMessageValidation();
        testException_ObjectIntegrityAfterCreation();
        testException_MultipleValidBogiesCreation();

        System.out.println("\nAll tests completed.");
    }

    public static void testException_ValidCapacityCreation() {
        try {
            Bogie b = new Bogie("Sleeper", 72);
            printResult("testException_ValidCapacityCreation", true, true);
        } catch (InvalidCapacityException e) {
            printResult("testException_ValidCapacityCreation", false, true);
        }
    }

    public static void testException_NegativeCapacityThrowsException() {
        try {
            new Bogie("Sleeper", -10);
            printResult("testException_NegativeCapacityThrowsException", false, true);
        } catch (InvalidCapacityException e) {
            printResult("testException_NegativeCapacityThrowsException", true, true);
        }
    }

    public static void testException_ZeroCapacityThrowsException() {
        try {
            new Bogie("Sleeper", 0);
            printResult("testException_ZeroCapacityThrowsException", false, true);
        } catch (InvalidCapacityException e) {
            printResult("testException_ZeroCapacityThrowsException", true, true);
        }
    }

    public static void testException_ExceptionMessageValidation() {
        try {
            new Bogie("Sleeper", 0);
        } catch (InvalidCapacityException e) {
            boolean result = e.getMessage().equals("Capacity must be greater than zero");
            printResult("testException_ExceptionMessageValidation", result, true);
        }
    }

    public static void testException_ObjectIntegrityAfterCreation() {
        try {
            Bogie b = new Bogie("AC Chair", 56);
            boolean result = b.type.equals("AC Chair") && b.capacity == 56;
            printResult("testException_ObjectIntegrityAfterCreation", result, true);
        } catch (InvalidCapacityException e) {
            printResult("testException_ObjectIntegrityAfterCreation", false, true);
        }
    }

    public static void testException_MultipleValidBogiesCreation() {
        try {
            new Bogie("S1", 72);
            new Bogie("S2", 72);
            new Bogie("A1", 56);
            printResult("testException_MultipleValidBogiesCreation", true, true);
        } catch (InvalidCapacityException e) {
            printResult("testException_MultipleValidBogiesCreation", false, true);
        }
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + " | Actual: " + actual);
        }
    }

    // Classes repeated here for standalone test execution
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) { super(message); }
    }

    static class Bogie {
        String type;
        int capacity;
        public Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) throw new InvalidCapacityException("Capacity must be greater than zero");
            this.type = type;
            this.capacity = capacity;
        }
    }
}
