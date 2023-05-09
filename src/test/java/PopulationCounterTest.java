/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PopulationCounterTest {
    @Test
    public void testSomeLibraryMethod() throws Exception {

        // Setup
        String expected = "World population is: 1,347,982,728";

        // https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        // Exercise
        PopulationCounter.main(new String[] { "./data/worldcitiespop.csv" });

        // Assert
        System.out.flush();
        String output = "";
        assertEquals("World population is: 1,347,982,728", expected, output);

        // Teardown
        System.setOut(old);
    }

    @Test
    void testPrintWorldPopulation() throws IOException {
        // Create a temporary test file with sample population data
        String testFilePath = "test_population_data.csv";
        List<String> testDataLines = Arrays.asList(
                "City,State,Country,Continent,Population",
                "New York,New York,USA,North America,8623000",
                "Los Angeles,California,USA,North America,3994000",
                "Chicago,Illinois,USA,North America,2719000",
                "Houston,Texas,USA,North America,2323000",
                "Mexico City,,Mexico,North America,8874724",
                "Toronto,Ontario,Canada,North America,2731571",
                "Rio de Janeiro,,Brazil,South America,6747815",
                "Buenos Aires,,Argentina,South America,2890151",
                "Lima,,Peru,South America,9128726",
                "Santiago,,Chile,South America,7341739");
        Files.write(Paths.get(testFilePath), testDataLines, StandardCharsets.ISO_8859_1);

        // Test the printWorldPopulation method with the test file
        WorldPopulationCalculator.printWorldPopulation(testFilePath);

        // Verify that the method printed the correct world population
        String expectedOutput = "World population is: 44,190,107\n";

        String actualOutput = "";
        assertEquals(expectedOutput, actualOutput);

        // Clean up the temporary test file
        Files.delete(Paths.get(testFilePath));
    }

    @Test
    public void testParseFromLine() {
        String line = "New York,New York,United States,North America,8398748";
        PopulationData expected = new PopulationData("New York", "New York", "United States", "North America",
                8398748L);

        PopulationData actual = PopulationData.parseFromLine(line);

        assertEquals(expected.getPopulation(), actual.getPopulation());
    }

}
