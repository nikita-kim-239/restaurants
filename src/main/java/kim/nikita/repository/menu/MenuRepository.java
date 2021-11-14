package kim.nikita.repository.menu;



import kim.nikita.model.Menu;

import java.util.List;

public interface MenuRepository {

    Menu save(Menu Menu);

    boolean delete(Integer id);

    Menu get(Integer id);

    List<Menu> getAll();
    
}
