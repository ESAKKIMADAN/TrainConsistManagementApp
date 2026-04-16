import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC5 ===");

        // 1. Create a LinkedHashSet<String> to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies: Engine, Sleeper, Cargo, Guard
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Bogies attached in sequence.");

        // 3. Attempt to attach a duplicate bogie intentionally
        System.out.println("Attempting to attach 'Sleeper' again...");
        trainFormation.add("Sleeper");

        // 4. Display the final formation order
        System.out.println("Final Train Formation (Order Maintained): " + trainFormation);

        // 5. Verification
        System.out.println("Total unique bogies in formation: " + trainFormation.size());
    }
}
