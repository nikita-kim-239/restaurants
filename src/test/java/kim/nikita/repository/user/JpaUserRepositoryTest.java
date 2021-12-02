package kim.nikita.repository.user;


import kim.nikita.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static kim.nikita.UserTestData.*;
import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaUserRepositoryTest {

    @Autowired
    private UserRepository repository;


    @Test
    public void getAll() {
        List<User> all = repository.getAll();
        assertMatch(all, admin, user);
    }


    @Test
    public void create() {
        User sidor = getNew();
        User created = repository.save(sidor);
        Integer newId = created.getId();
        sidor.setId(newId);
        assertMatch(created, sidor);
        assertMatch(repository.get(newId), sidor);
    }

    @Test
    public void delete() {

        assertTrue(repository.delete(USER_ID));
        assertNull(repository.get(USER_ID));
    }

    @Test
    public void deleteNotFound() {

        assertFalse(repository.delete(-1));

    }

    @Test
    public void getById() {
        assertEquals(user, repository.get(USER_ID));
    }

    @Test
    public void update() {

        assertEquals(updatedUser, repository.save(updatedUser));
    }

}
