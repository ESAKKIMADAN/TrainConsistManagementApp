import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC8 ===");

        // 1. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Full Bogie List: " + passengerBogies);

        // 2. Use the Stream API to filter bogies with capacity > 60
        System.out.println("Filtering bogies with capacity > 60...");
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(bogie -> bogie.getCapacity() > 60)
                .collect(Collectors.toList());

        // 3. Display the filtered bogies
        System.out.println("Filtered Bogies (High Capacity):");
        for (Bogie bogie : highCapacityBogies) {
            System.out.println("Bogie: " + bogie.getName() + ", Capacity: " + bogie.getCapacity() + " seats");
        }
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
