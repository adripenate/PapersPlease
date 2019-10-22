package papersplease.actions;

import papersplease.Bulletin;
import papersplease.Officer;
import papersplease.repository.OfficerRepository;

public class ReceiveBulletin {
    public void execute(Bulletin bulletin, OfficerRepository officerRepository, int gameID) {
        Officer officer = officerRepository.recover(gameID);
        officer.receiveBulletin(bulletin);
        officerRepository.save(officer);
    }
}
