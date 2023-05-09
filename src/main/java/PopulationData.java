public class PopulationData {
    private long population;

    public PopulationData(String terms, String terms2, String terms3, String terms4, long population) {
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public static PopulationData parseFromLine(String line) {
        String[] terms = line.split(",");
        String popText = terms[4];
        if (popText.length() == 0) {
            return null;
        }
        long population = Long.parseLong(popText);
        return new PopulationData(popText, popText, popText, popText, population);
    }
}
