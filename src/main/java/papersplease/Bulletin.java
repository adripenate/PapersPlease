package papersplease;

public class Bulletin {
    private final String[] cities;
    private final Class[] documents;
    private final String[] vaccinations;
    private final String[] wantedCriminal;

    public Bulletin(String[] cities, Class[] documents, String[] vaccinations, String[] wantedCriminal) {
        this.cities = cities;
        this.documents = documents;
        this.vaccinations = vaccinations;
        this.wantedCriminal = wantedCriminal;
    }
}
