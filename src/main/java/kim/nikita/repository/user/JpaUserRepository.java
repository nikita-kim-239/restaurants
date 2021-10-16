package kim.nikita.repository.user;


import kim.nikita.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository{


    @PersistenceContext
    private EntityManager em;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery("GET_ALL_SORTED",User.class).getResultList();
    }
}
