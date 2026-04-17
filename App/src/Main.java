import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC20 ===");

        // 1. Case: Search attempt on an empty train consist
        String[] emptyBogieIds = {};
        System.out.println("\n--- Testing Search on Empty Consist ---");
        try {
            executeSearch(emptyBogieIds, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("FAIL-FAST ERROR: " + e.getMessage());
        }

        // 2. Case: Search attempt on a populated train consist
        String[] populatedBogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        System.out.println("\n--- Testing Search on Populated Consist ---");
        try {
            executeSearch(populatedBogieIds, "BG309");
            executeSearch(populatedBogieIds, "BG999");
        } catch (IllegalStateException e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\nProgram continued safely after handling state-based exceptions.");
    }

    // executeSearch method with defensive validation
    public static void executeSearch(String[] bogieIds, String target) {
        // Validation Step: Throw IllegalStateException if data is missing
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot search in an empty train consist. Please add bogies first.");
        }

        System.out.println("Validating train consist state... PASSED.");
        
        // Use Binary Search (from UC19 logic)
        // Note: For binary search, data must be sorted. bogieIds are already sorted here.
        int result = Arrays.binarySearch(bogieIds, target);

        if (result >= 0) {
            System.out.println("✔ Bogie Found: " + target + " is present.");
        } else {
            System.out.println("❌ Bogie Not Found: " + target + " is not in the list.");
        }
    }
}
