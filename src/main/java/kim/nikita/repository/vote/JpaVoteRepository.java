package kim.nikita.repository.vote;


import kim.nikita.model.User;
import kim.nikita.model.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaVoteRepository implements VoteRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Vote save(Vote vote) {
        if (vote.isNew()) {
            em.persist(vote);
            return vote;
        } else {
            return em.merge(vote);
        }
    }

    @Override
    @Transactional
    public boolean delete (int id) {

            Query query = em.createQuery("DELETE FROM Vote v WHERE v.id=:id");
            return query.setParameter("id", id).executeUpdate() != 0;

    }

    @Override
    public Vote get(int id) {
        return em.find(Vote.class,id);
    }

    @Override
    public List<Vote> getAll() {
        return em.createNamedQuery("GET_ALL_VOTES", Vote.class).getResultList();
    }
}
