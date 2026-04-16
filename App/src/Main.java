import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC7 ===");

        // 1. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add bogies like Sleeper, AC Chair, and First Class with capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Bogies before sorting: " + passengerBogies);

        // 3. Use Comparator.comparingInt() to define sorting based on capacity
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // 4. Sort the list and display the sorted bogies
        System.out.println("Sorted Bogies by Capacity:");
        for (Bogie bogie : passengerBogies) {
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
