package kim.nikita.repository.dish;


import kim.nikita.model.Dish;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kim.nikita.DishTestData.*;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaDishRepositoryTest {

    @Autowired
    private DishRepository repository;

    @Test
    public void getAll() {
        List<Dish> all = repository.getAll();
        List<Dish> expected = Arrays.asList(BREAD, JUICE, MEAT, SALAD, TEA, WATER);
        assertEquals(expected, all);
    }

    @Test
    public void create() {
        Dish iceCream = getNew();
        Dish created = repository.save(iceCream);
        Integer newId = created.getId();
        iceCream.setId(newId);
        assertEquals(iceCream, created);

    }

    @Test
    public void delete() {

        assertTrue(repository.delete(BREAD_ID));
        assertNull(repository.get(BREAD_ID));
    }

    @Test
    public void deleteNotFound() {

        assertFalse(repository.delete(-1));

    }

    @Test
    public void getById() {
        assertEquals(BREAD, repository.get(BREAD_ID));
    }

    @Test
    public void update() {

        assertEquals(BREAD_UPDATED, repository.save(BREAD_UPDATED));
    }

}
