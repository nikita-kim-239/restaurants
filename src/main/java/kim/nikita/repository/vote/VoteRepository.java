package kim.nikita.repository.vote;

import kim.nikita.model.Vote;

import java.util.List;

public interface VoteRepository {

    Vote save(Vote Vote);

    boolean delete(Integer id);

    Vote get(Integer id);

    List<Vote> getAll();

}
