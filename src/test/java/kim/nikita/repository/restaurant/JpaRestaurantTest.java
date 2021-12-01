package kim.nikita.repository.restaurant;


import kim.nikita.model.Restaurant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static kim.nikita.MenuTestData.*;
import static kim.nikita.MenuTestData.MENU_UPDATED;
import static kim.nikita.RestaurantTestData.*;
import static kim.nikita.RestaurantTestData.assertMatch;
import static kim.nikita.RestaurantTestData.getNew;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaRestaurantTest {

    @Autowired
    private RestaurantRepository repository;


    @Test
    public void getAll() {
        List<Restaurant> all = repository.getAll();
        assertMatch(all, CHINESE_RESTAURANT, FRENCH_RESTAURANT, ITALIAN_RESTAURANT, RUSSIAN_RESTAURANT);
    }

    @Test
    public void create() {
        Restaurant restaurant = getNew();
        Restaurant created = repository.save(restaurant);
        Integer newId = created.getId();
        restaurant.setId(newId);
        assertEquals(created, restaurant);
        assertEquals(repository.get(newId), created);
    }

    @Test
    public void delete() {

        assertTrue(repository.delete(RUSSIAN_RESTAURANT_ID));
        assertNull(repository.get(RUSSIAN_RESTAURANT_ID));
    }

    @Test
    public void deleteNotFound() {
        assertFalse(repository.delete(-1));
    }

    @Test
    public void getById() {
        assertEquals(RUSSIAN_RESTAURANT, repository.get(RUSSIAN_RESTAURANT_ID));
    }

    @Test
    public void update() {

        assertEquals(UPDATED_RESTAURANT, repository.save(UPDATED_RESTAURANT));
    }
}
