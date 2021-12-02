package kim.nikita.repository.user;


import kim.nikita.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {

        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }

    }

    @Override
    @Transactional
    public boolean delete(Integer id) {

        Query query = em.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;

    }

    @Override
    public User get(Integer id) {

        return em.find(User.class, id);

    }

    @Override
    public User getByEmail(String email) {
        return (User)em.createNamedQuery("GET_BY_EMAIL").setParameter("email",email).getSingleResult();
    }


    @Override
    public List<User> getAll() {

        return em.createNamedQuery("GET_ALL_SORTED", User.class).getResultList();
    }
}
