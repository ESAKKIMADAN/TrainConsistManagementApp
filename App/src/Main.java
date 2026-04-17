public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC15 ===");

        // 1. Create goods bogies
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // 2. Attempt safe cargo assignment
        assignCargoToBogie(cylindrical, "Petroleum");

        // 3. Attempt unsafe cargo assignment
        assignCargoToBogie(rectangular, "Petroleum");

        System.out.println("\nProgram execution continued safely after operation attempts.");
    }

    // Helper method to demonstrate try-catch-finally
    public static void assignCargoToBogie(GoodsBogie bogie, String cargo) {
        System.out.println("\n--- Attempting to assign " + cargo + " to " + bogie.getShape() + " bogie ---");
        try {
            bogie.assignCargo(cargo);
            System.out.println("SUCCESS: Cargo assigned successfully.");
        } catch (CargoSafetyException e) {
            System.err.println("SAFETY ERROR: " + e.getMessage());
        } finally {
            System.out.println("NOTIFICATION: Cargo assignment validation process completed.");
        }
    }

    // Custom Runtime Exception for cargo safety
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // GoodsBogie class with operational safety logic
    static class GoodsBogie {
        private String shape;
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String newCargo) {
            // Unsafe rule: Petroleum cannot be assigned to Rectangular bogies
            if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("UNSAFE ASSIGNMENT: Petroleum cannot be carried in Rectangular bogies due to fire hazard.");
            }
            this.cargo = newCargo;
        }

        public String getShape() { return shape; }
        public String getCargo() { return cargo; }
    }
}
