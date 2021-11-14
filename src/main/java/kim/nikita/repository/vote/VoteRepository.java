package kim.nikita.repository.vote;

import kim.nikita.model.User;
import kim.nikita.model.Vote;

import java.util.List;

public interface VoteRepository {

    Vote save(Vote vote);

    boolean delete(int id);

    Vote get(int id);

    List<Vote> getAll();


}
