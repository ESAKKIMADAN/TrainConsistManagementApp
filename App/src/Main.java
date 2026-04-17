public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC18 ===");

        // 1. Create an array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Define search targets
        String searchFoundTarget = "BG309";
        String searchNotFoundTarget = "BG999";

        // 3. Perform Linear Search
        System.out.println("Searching for bogie IDs in the consist...");
        
        displaySearchResult(searchFoundTarget, linearSearch(bogieIds, searchFoundTarget));
        displaySearchResult(searchNotFoundTarget, linearSearch(bogieIds, searchNotFoundTarget));

        System.out.println("\nSearch operations completed successfully using Sequential Traversal.");
    }

    // Linear Search algorithm: Traverses the array one by one
    public static boolean linearSearch(String[] arr, String key) {
        for (String element : arr) {
            // Compare each element with the search key
            if (element.equals(key)) {
                return true; // Match found, terminate search early
            }
        }
        return false; // Traversed entire array, no match found
    }

    public static void displaySearchResult(String id, boolean found) {
        if (found) {
            System.out.println("✔ Bogie Found: " + id + " is present in the train consist.");
        } else {
            System.out.println("❌ Bogie Not Found: " + id + " could not be located.");
        }
    }
}
