package kim.nikita.repository.menu;

import kim.nikita.model.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaMenuRepository implements MenuRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Menu save(Menu menu) {
        if (menu.isNew()) {
            em.persist(menu);
            return menu;
        } else {
            return em.merge(menu);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        Query query = em.createQuery("DELETE FROM Menu m WHERE m.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Menu get(Integer id) {
        return em.find(Menu.class, id);
    }

    @Override
    public List<Menu> getAll() {
        return em.createNamedQuery("GET_ALL_MENUS", Menu.class).getResultList();
    }
}
