import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC6 ===");

        // 1. Create a HashMap<String, Integer> to store bogie-capacity information
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 2. Use the put() method to map each bogie to its capacity
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);

        System.out.println("Bogie Capacities Stored.");

        // 3. Iterate over the map using entrySet()
        System.out.println("Iterating through capacity details:");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            // 4. Display each bogie along with its corresponding capacity
            System.out.println("Bogie: " + entry.getKey() + ", Capacity: " + entry.getValue() + " seats");
        }
    }
}
