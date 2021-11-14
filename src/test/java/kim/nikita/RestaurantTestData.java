package kim.nikita;

import kim.nikita.model.Dish;
import kim.nikita.model.Restaurant;

import java.util.Arrays;

import static kim.nikita.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTestData {

    public static final int RUSSIAN_RESTAURANT_ID=START_SEQ+8;
    public static final int FRENCH_RESTAURANT_ID=START_SEQ+9;
    public static final int ITALIAN_RESTAURANT_ID=START_SEQ+10;
    public static final int CHINESE_RESTAURANT_ID=START_SEQ+11;

    public static final Restaurant RUSSIAN_RESTAURANT =new Restaurant(RUSSIAN_RESTAURANT_ID,"Russian");
    public static final Restaurant FRENCH_RESTAURANT =new Restaurant(FRENCH_RESTAURANT_ID,"French");
    public static final Restaurant ITALIAN_RESTAURANT =new Restaurant(ITALIAN_RESTAURANT_ID,"Italian");
    public static final Restaurant CHINESE_RESTAURANT =new Restaurant(CHINESE_RESTAURANT_ID,"Chinese");

    public static Restaurant getNew()
    {
        return new Restaurant(null,"New Restaurant");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
