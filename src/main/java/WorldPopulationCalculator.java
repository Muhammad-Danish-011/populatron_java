import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class WorldPopulationCalculator {
    public static void printWorldPopulation(String path) throws IOException {
        List<PopulationData> populationDataList = PopulationDataReader.readPopulationData(path);
        long sum = populationDataList.stream()
                .mapToLong(PopulationData::getPopulation)
                .sum();

        String num = NumberFormat.getInstance(Locale.getDefault()).format(sum);
        System.out.printf("World population is: %s\n", num);
    }
}
