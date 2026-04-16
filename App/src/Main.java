import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC9 ===");

        // 1. Create a List<Bogie> with multiple bogie objects, including some duplicates
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Original Bogie List: " + passengerBogies);

        // 2. Use the Stream API to group bogies by name
        System.out.println("Grouping bogies by type...");
        Map<String, List<Bogie>> groupedBogies = passengerBogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 3. Display the grouped result
        System.out.println("Grouped Result (Map): " + groupedBogies);
    }

    // Static inner class Bogie
    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + ")";
        }
    }
}
