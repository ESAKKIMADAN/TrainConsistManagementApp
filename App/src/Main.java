import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC13 ===");

        // 1. Create a dataset of 10,000 bogies for benchmarking
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Bogie " + i, (int) (Math.random() * 100)));
        }

        System.out.println("Total Bogies: " + bogies.size());

        // 2. Loop-Based Filtering Benchmarking
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // 3. Stream-Based Filtering Benchmarking
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 4. Display benchmark results
        System.out.println("\n--- Performance Results ---");
        System.out.println("Loop-Based Filtering Time:   " + loopDuration + " nanoseconds");
        System.out.println("Stream-Based Filtering Time: " + streamDuration + " nanoseconds");
        System.out.println("Filtered Count (Loop):       " + loopFiltered.size());
        System.out.println("Filtered Count (Stream):     " + streamFiltered.size());
    }

    // Bogie class with capacity for benchmarking
    static class Bogie {
        private String id;
        private int capacity;

        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }
}
