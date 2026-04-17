import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC19 ===");

        // 1. Create an unsorted array of bogie IDs
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        System.out.println("Original (Unsorted) IDs: " + Arrays.toString(bogieIds));

        // 2. Precondition: Sort the data before applying Binary Search
        System.out.println("Sorting bogie IDs for optimized lookup...");
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs: " + Arrays.toString(bogieIds));

        // 3. Perform Binary Search
        String searchTarget = "BG309";
        System.out.println("\nSearching for bogie ID: " + searchTarget);
        
        boolean found = binarySearch(bogieIds, searchTarget);
        
        if (found) {
            System.out.println("✔ Result: Bogie " + searchTarget + " found efficiently using Binary Search.");
        } else {
            System.out.println("❌ Result: Bogie " + searchTarget + " could not be located.");
        }

        System.out.println("\nSearch operation completed using Divide-and-Conquer Strategy.");
    }

    // Binary Search algorithm: Repeatedly halves the search range
    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = arr[mid].compareTo(key);

            if (comparison == 0) {
                return true; // Match found at middle
            } else if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return false; // Search range exhausted
    }
}
