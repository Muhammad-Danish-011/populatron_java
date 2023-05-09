import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PopulationDataReader {

    public static List<PopulationData> readPopulationData(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.ISO_8859_1);
        return lines.stream().skip(1)
                .map(line -> line.split(","))
                .filter(terms -> terms.length >= 5 && !terms[4].isEmpty())
                .map(terms -> new PopulationData(
                        terms[0],
                        terms[1],
                        terms[2],
                        terms[3],
                        Long.parseLong(terms[4])
                ))
                .collect(Collectors.toList());
    }
}
