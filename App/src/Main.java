import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC10 ===");

        // 1. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Bogie List: " + passengerBogies);

        // 2. Use the Stream API to calculate total seating capacity
        System.out.println("Calculating total seating capacity...");
        int totalSeats = passengerBogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // 3. Display the total seating capacity
        System.out.println("Total Seating Capacity of the Train: " + totalSeats + " seats");
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
