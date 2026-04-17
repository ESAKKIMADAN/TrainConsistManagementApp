public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC15 Cargo Safety Validation Tests ---");

        testCargo_SafeAssignment();
        testCargo_UnsafeAssignmentHandled();
        testCargo_CargoNotAssignedAfterFailure();
        testCargo_ProgramContinuesAfterException();
        testCargo_FinallyBlockExecution();

        System.out.println("\nAll tests completed.");
    }

    public static void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        try {
            b.assignCargo("Petroleum");
            boolean result = b.cargo.equals("Petroleum");
            printResult("testCargo_SafeAssignment", result, true);
        } catch (CargoSafetyException e) {
            printResult("testCargo_SafeAssignment", false, true);
        }
    }

    public static void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        try {
            b.assignCargo("Petroleum");
            printResult("testCargo_UnsafeAssignmentHandled", false, true);
        } catch (CargoSafetyException e) {
            printResult("testCargo_UnsafeAssignmentHandled", true, true);
        }
    }

    public static void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        try {
            b.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            boolean result = (b.cargo == null);
            printResult("testCargo_CargoNotAssignedAfterFailure", result, true);
        }
    }

    public static void testCargo_ProgramContinuesAfterException() {
        boolean executionFlowMaintained = false;
        try {
            GoodsBogie b1 = new GoodsBogie("Rectangular");
            b1.assignCargo("Petroleum"); // This fails
        } catch (CargoSafetyException e) {
            // Program continues...
            GoodsBogie b2 = new GoodsBogie("Cylindrical");
            b2.assignCargo("Petroleum"); // This succeeds
            executionFlowMaintained = b2.cargo.equals("Petroleum");
        }
        printResult("testCargo_ProgramContinuesAfterException", executionFlowMaintained, true);
    }

    public static void testCargo_FinallyBlockExecution() {
        final boolean[] finallyExecuted = {false};
        try {
            GoodsBogie b = new GoodsBogie("Rectangular");
            b.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // handle
        } finally {
            finallyExecuted[0] = true;
        }
        printResult("testCargo_FinallyBlockExecution", finallyExecuted[0], true);
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + " | Actual: " + actual);
        }
    }

    // Repeated logic for testing
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) { super(message); }
    }

    static class GoodsBogie {
        String shape;
        String cargo;
        public GoodsBogie(String shape) { this.shape = shape; }
        public void assignCargo(String newCargo) {
            if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("unsafe");
            }
            this.cargo = newCargo;
        }
    }
}
