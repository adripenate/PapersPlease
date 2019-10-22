import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReceiveBulletinShould {
    @Test
    public void assign_bulletin() {
        Bulletin bulletin = new Bulletin(new String[]{"Arstotzka"}, new Class[]{ID_Card.class},
                null, new String[]{"Pepe Viyuela"});

        OfficerRepository officerRepository = mock(OfficerRepository.class);
        when(officerRepository.recover()).thenReturn(new Officer());
        ArgumentCaptor<Officer> argumentCaptor = ArgumentCaptor.forClass(Officer.class);
        verify(officerRepository).save(argumentCaptor.capture());

        new ReceiveBulletin().execute(bulletin, officerRepository, 1);

        assertThat(argumentCaptor.getValue().bulletin).isEqualToComparingFieldByField(bulletin);
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

    private class Officer {
        private Bulletin bulletin;

        public void receiveBulletin(Bulletin bulletin) {
            this.bulletin = bulletin;
        }

    }

    private interface OfficerRepository {
        Officer recover();

        void save(Officer officer);
    }

    private class ReceiveBulletin {
        public void execute(Bulletin bulletin, OfficerRepository officerRepository, int gameID) {

        }
    }
}
