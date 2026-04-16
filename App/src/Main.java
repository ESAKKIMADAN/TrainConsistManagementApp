import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC4 ===");

        // 1. Create a LinkedList<String> for the consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add bogies: Engine, Sleeper, AC, Cargo, Guard
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial consist: " + trainConsist);

        // 3. Insert a Pantry Car at position 2 (between Sleeper and AC)
        System.out.println("Inserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");

        // 4. Remove the first and last bogie
        System.out.println("Removing first and last bogies (Engine and Guard)...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 5. Display the final ordered train consist
        System.out.println("Final ordered train consist: " + trainConsist);
    }
}
