import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Print welcome message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Initialize an empty List using ArrayList
        // We use the List interface for abstraction and ArrayList for dynamic sizing
        List<String> bogieList = new ArrayList<>();

        // Step 3: Display the initial bogie count using size()
        System.out.println("Train consist initialized with " + bogieList.size() + " bogies.");

        // Continued execution...
        System.out.println("Program continues...");
    }
}
