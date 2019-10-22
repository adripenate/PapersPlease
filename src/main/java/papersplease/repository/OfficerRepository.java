package papersplease.repository;

import papersplease.Officer;

public interface OfficerRepository {
    Officer recover(int gameID);
    void save(Officer officer);
}
