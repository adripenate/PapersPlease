import org.junit.Test;

public class ReceiveBulletinShould {
    @Test
    public void assing_bulletin() {
        Bulletin bulletin = new Bulletin(new String[]{"Arstotzka"}, new Class[]{ID_Card.class},
                null, new String[]{"Pepe Viyuela"});

    }

    private class Bulletin {
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

    private class ID_Card {
    }
}
