import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC14 ===");

        try {
            // 1. Attempt to create valid bogies
            System.out.println("Creating valid bogies...");
            Bogie sleeper = new Bogie("Sleeper", 72);
            Bogie acChair = new Bogie("AC Chair", 56);
            System.out.println("Successfully created: " + sleeper);
            System.out.println("Successfully created: " + acChair);

            // 2. Attempt to create an invalid bogie (Zero Capacity)
            System.out.println("\nAttempting to create a bogie with zero capacity...");
            Bogie invalidZero = new Bogie("Broken Bogie", 0);
            
        } catch (InvalidCapacityException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        try {
            // 3. Attempt to create an invalid bogie (Negative Capacity)
            System.out.println("\nAttempting to create a bogie with negative capacity...");
            Bogie invalidNegative = new Bogie("Ghost Bogie", -10);

        } catch (InvalidCapacityException e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nProgram execution continued safely after handling exceptions.");
    }

    // Custom Exception for bogie capacity validation
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Bogie class with fail-fast validation in constructor
    static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Capacity: " + capacity + ")";
        }
    }
}
