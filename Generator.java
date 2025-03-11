import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        String filename = "very_big_input.txt";
        int numberOfElements = 1000; // Change this to generate more numbers
        int maxNumber = 10000; // Maximum value for random numbers

        try (FileWriter writer = new FileWriter(filename)) {
            Random random = new Random();
            for (int i = 0; i < numberOfElements; i++) {
                writer.write(random.nextInt(maxNumber) + (i < numberOfElements - 1 ? "," : ""));
            }
            System.out.println("Generated file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}