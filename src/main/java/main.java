import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            WorldPopulationCalculator.printWorldPopulation(args[0]);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
