import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App — UC11 ===");

        // Define Regex patterns for Train ID and Cargo Code
        // Train ID: TRN- (fixed) followed by exactly 4 digits
        String trainIdRegex = "TRN-\\d{4}";
        // Cargo Code: PET- (fixed) followed by exactly 2 uppercase letters
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        // Sample Inputs to Validate
        String[] testTrainIds = {"TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC"};

        System.out.println("\n--- Validating Train IDs ---");
        for (String id : testTrainIds) {
            Matcher matcher = trainIdPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("VALID Train ID: " + id);
            } else {
                System.out.println("INVALID Train ID: " + id);
            }
        }

        System.out.println("\n--- Validating Cargo Codes ---");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoCodePattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("VALID Cargo Code: " + code);
            } else {
                System.out.println("INVALID Cargo Code: " + code);
            }
        }
    }
}
