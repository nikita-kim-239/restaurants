package kim.nikita.repository.dish;


import kim.nikita.model.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaDishRepository implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Dish save(Dish dish) {
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        } else {
            return em.merge(dish);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        Query query = em.createQuery("DELETE FROM Dish d WHERE d.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Dish get(Integer id) {
        return em.find(Dish.class, id);
    }

    @Override
    public List<Dish> getAll() {
        return em.createNamedQuery("GET_ALL_DISHES", Dish.class).getResultList();
    }
}
