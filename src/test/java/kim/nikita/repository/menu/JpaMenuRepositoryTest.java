package kim.nikita.repository.menu;


import kim.nikita.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static kim.nikita.MenuTestData.*;
import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaMenuRepositoryTest {

    @Autowired
    private MenuRepository repository;


    @Test
    public void getAll() {
        List<Menu> all = repository.getAll();
        assertMatch(all, MENU1, MENU2, MENU3, MENU4, MENU5);
    }

    @Test
    public void create() {
        Menu newMenu = getNewMenu();
        Menu created = repository.save(newMenu);
        Integer newId = created.getId();
        newMenu.setId(newId);
        assertEquals(newMenu, created);

    }

    @Test
    public void delete() {

        assertTrue(repository.delete(MENU1_ID));
        assertNull(repository.get(MENU1_ID));
    }

    @Test
    public void deleteNotFound() {

        assertFalse(repository.delete(-1));

    }

    @Test
    public void getById() {
        assertEquals(MENU1, repository.get(MENU1_ID));
    }

    @Test
    public void update() {

        assertEquals(MENU_UPDATED, repository.save(MENU_UPDATED));
    }

}
