import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC12 ===");

        // 1. Create a collection of Goods Bogies with Type and Cargo
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Validating train safety compliance...");

        // 2. Use allMatch() with conditional logic to check safety compliance
        // Rule: Cylindrical bogies must carry only Petroleum
        boolean isSafe = goodsBogies.stream().allMatch(bogie -> 
            !bogie.getType().equalsIgnoreCase("Cylindrical") || 
            bogie.getCargo().equalsIgnoreCase("Petroleum")
        );

        // 3. Display the safety compliance status
        if (isSafe) {
            System.out.println("RESULT: The train is safety compliant. All rules are satisfied.");
        } else {
            System.out.println("RESULT: Safety violation detected! Check cargo assignments.");
        }
    }

    // GoodsBogie class to represent cargo constraints
    static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " [" + cargo + "]";
        }
    }
}
