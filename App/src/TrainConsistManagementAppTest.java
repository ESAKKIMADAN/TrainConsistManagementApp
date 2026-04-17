import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest {

    public static void main(String[] args) {
        System.out.println("--- Running UC13 Performance Comparison Tests ---");

        testLoopFilteringLogic();
        testStreamFilteringLogic();
        testLoopAndStreamResultsMatch();
        testExecutionTimeMeasurement();
        testLargeDatasetProcessing();

        System.out.println("\nAll tests completed.");
    }

    public static void testLoopFilteringLogic() {
        List<Bogie> bogies = createTestBogies(10);
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) filtered.add(b);
        }
        boolean result = filtered.stream().allMatch(b -> b.getCapacity() > 60);
        printResult("testLoopFilteringLogic", result, true);
    }

    public static void testStreamFilteringLogic() {
        List<Bogie> bogies = createTestBogies(10);
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        boolean result = filtered.stream().allMatch(b -> b.getCapacity() > 60);
        printResult("testStreamFilteringLogic", result, true);
    }

    public static void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createTestBogies(100);
        
        // Loop
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) if (b.getCapacity() > 60) loopFiltered.add(b);
        
        // Stream
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        
        boolean result = (loopFiltered.size() == streamFiltered.size());
        printResult("testLoopAndStreamResultsMatch", result, true);
    }

    public static void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Small delay
        for(int i=0; i<1000; i++) { Math.sqrt(i); }
        long end = System.nanoTime();
        boolean result = (end - start) > 0;
        printResult("testExecutionTimeMeasurement", result, true);
    }

    public static void testLargeDatasetProcessing() {
        List<Bogie> bogies = createTestBogies(10000);
        long start = System.nanoTime();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long end = System.nanoTime();
        boolean result = (end - start) > 0 && filtered.size() > 0;
        printResult("testLargeDatasetProcessing", result, true);
    }

    private static List<Bogie> createTestBogies(int count) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bogies.add(new Bogie("B" + i, (i % 100))); // Distribute capacities 0-99
        }
        return bogies;
    }

    private static void printResult(String testName, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " | Expected: " + expected + " | Actual: " + actual);
        }
    }

    static class Bogie {
        private String id;
        private int capacity;
        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }
        public int getCapacity() { return capacity; }
    }
}
