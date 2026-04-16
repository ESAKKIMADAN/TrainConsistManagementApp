import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC2 ===");

        // 1. Create an ArrayList<String> for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Passenger bogies added: " + passengerBogies);

        // 4. Remove one bogie (AC Chair)
        System.out.println("Removing AC Chair...");
        passengerBogies.remove("AC Chair");

        // 5. Use contains() to check if Sleeper exists
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Bogie 'Sleeper' exists in the consist.");
        } else {
            System.out.println("Bogie 'Sleeper' not found.");
        }

        // 6. Print final list state
        System.out.println("Final passenger bogie list: " + passengerBogies);
    }
}
