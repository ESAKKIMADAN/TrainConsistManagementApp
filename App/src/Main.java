public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC16 ===");

        // 1. Create an array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Original Capacities: ");
        printArray(capacities);

        // 2. Implement Bubble Sort Algorithm
        // External loop for passes over the array
        for (int i = 0; i < capacities.length - 1; i++) {
            // Internal loop for comparing adjacent elements
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap values if they are out of order
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // 3. Display the sorted capacities
        System.out.print("Sorted Capacities (Bubble Sort): ");
        printArray(capacities);

        System.out.println("\nSorting completed successfully without library methods.");
    }

    // Helper method to print array elements
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println(" ]");
    }
}
