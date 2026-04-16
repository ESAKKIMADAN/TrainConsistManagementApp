import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC3 ===");

        // 1. Create a HashSet<String> for bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // 2. Add multiple bogie IDs, including intentional duplicates
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // Intentional duplicate
        bogieIds.add("BG103");

        // 3. Print the final set
        System.out.println("Bogie IDs registered: " + bogieIds);

        // 4. Observe that duplicates are removed automatically
        System.out.println("Total unique bogies: " + bogieIds.size());
        
        System.out.println("Deduplication logic verified using HashSet.");
    }
}
