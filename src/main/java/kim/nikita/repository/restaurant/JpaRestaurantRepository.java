package kim.nikita.repository.restaurant;


import kim.nikita.model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class JpaRestaurantRepository implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        Query query = em.createQuery("DELETE FROM Restaurant r WHERE r.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Restaurant get(Integer id) {
        return em.find(Restaurant.class, id);
    }

    @Override
    public List<Restaurant> getAll() {

        return em.createNamedQuery("GET_ALL_RESTAURANTS", Restaurant.class).getResultList();
    }
}
