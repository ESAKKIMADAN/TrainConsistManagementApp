import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC12 Safety Compliance Tests ---");

        testSafety_AllBogiesValid();
        testSafety_CylindricalWithInvalidCargo();
        testSafety_NonCylindricalBogiesAllowed();
        testSafety_MixedBogiesWithViolation();
        testSafety_EmptyBogieList();

        System.out.println("\nAll tests completed.");
    }

    public static void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Box", "Coal"));

        boolean result = validateSafety(bogies);
        printResult("testSafety_AllBogiesValid", result, true);
    }

    public static void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        boolean result = validateSafety(bogies);
        printResult("testSafety_CylindricalWithInvalidCargo", result, false);
    }

    public static void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Open", "Steel"));

        boolean result = validateSafety(bogies);
        printResult("testSafety_NonCylindricalBogiesAllowed", result, true);
    }

    public static void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Box", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Water")); // Invalid

        boolean result = validateSafety(bogies);
        printResult("testSafety_MixedBogiesWithViolation", result, false);
    }

    public static void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        boolean result = validateSafety(bogies);
        printResult("testSafety_EmptyBogieList", result, true);
    }

    // Helper method for validation logic
    private static boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> 
            !b.getType().equalsIgnoreCase("Cylindrical") || 
            b.getCargo().equalsIgnoreCase("Petroleum")
        );
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + " | Actual: " + actual);
        }
    }

    // GoodsBogie inner class for testing
    static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }
}
