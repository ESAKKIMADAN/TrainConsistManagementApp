import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC17 ===");

        // 1. Create an array of bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        // 2. Use Arrays.sort() for optimized alphabetical sorting
        System.out.println("Sorting bogie names using Arrays.sort()...");
        Arrays.sort(bogieNames);

        // 3. Display the sorted result
        System.out.println("Sorted Bogie Names:   " + Arrays.toString(bogieNames));

        System.out.println("\nAlphabetical sorting completed using Java Standard Library.");
    }
}
