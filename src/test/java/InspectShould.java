import org.junit.Test;
import papersplease.Bulletin;
import papersplease.ID_Card;
import papersplease.Officer;
import papersplease.repository.OfficerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class InspectShould {
    @Test
    public void let_entrant_pass_if_IDCard_is_present() {
        Bulletin bulletin = new Bulletin(new String[]{"Arstotzka"}, new Class[]{ID_Card.class},
                null, new String[]{"Pepe Viyuela"});
        int gameID = 1;
        OfficerRepository officerRepository = mock(OfficerRepository.class);
        Officer officer = new Officer();
        officer.receiveBulletin(bulletin);
        when(officerRepository.recover(gameID)).thenReturn(officer);
        Entrant entrant = new Entrant();
        entrant.giveIDCard(new ID_Card("District", "Name", "01/01/1999", 1, 1));

        String response = new Inspect().execute(officerRepository, gameID, entrant);

        assertThat(response).isEqualTo("Glory to Arstotzka.");
    }

    private class Inspect {
        public String execute(OfficerRepository officerRepository, int gameID, Entrant entrant) {
            return "Glory to Arstotzka.";
        }
    }

    private class Entrant {
        private ID_Card id_card;

        public void giveIDCard(ID_Card id_card) {
            this.id_card = id_card;
        }
    }
}
