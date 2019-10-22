import org.junit.Test;
import org.mockito.ArgumentCaptor;
import papersplease.Bulletin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ReceiveBulletinShould {
    @Test
    public void assign_bulletin() {
        Bulletin bulletin = new Bulletin(new String[]{"Arstotzka"}, new Class[]{ID_Card.class},
                null, new String[]{"Pepe Viyuela"});
        int gameID = 1;
        OfficerRepository officerRepository = mock(OfficerRepository.class);
        when(officerRepository.recover(gameID)).thenReturn(new Officer());
        ArgumentCaptor<Officer> argumentCaptor = ArgumentCaptor.forClass(Officer.class);

        new ReceiveBulletin().execute(bulletin, officerRepository, gameID);

        verify(officerRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().bulletin).isEqualToComparingFieldByField(bulletin);
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
        Officer recover(int gameID);
        void save(Officer officer);
    }

    private class ReceiveBulletin {
        public void execute(Bulletin bulletin, OfficerRepository officerRepository, int gameID) {
            Officer officer = officerRepository.recover(gameID);
            officer.receiveBulletin(bulletin);
            officerRepository.save(officer);
        }
    }
}
