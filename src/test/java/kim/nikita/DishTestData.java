package kim.nikita;

import kim.nikita.model.Dish;
import kim.nikita.model.Role;
import kim.nikita.model.User;

import java.util.Arrays;
import java.util.Collections;

import static kim.nikita.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class DishTestData {

    public static final int BREAD_ID = START_SEQ + 2;
    public static final int TEA_ID = START_SEQ + 3;
    public static final int JUICE_ID = START_SEQ + 4;
    public static final int MEAT_ID = START_SEQ + 5;
    public static final int SALAD_ID = START_SEQ + 6;
    public static final int WATER_ID = START_SEQ + 7;

    public static final Dish BREAD = new Dish(BREAD_ID, "bread");
    public static final Dish TEA = new Dish(TEA_ID, "tea");
    public static final Dish JUICE = new Dish(JUICE_ID, "juice");
    public static final Dish MEAT = new Dish(MEAT_ID, "meat");
    public static final Dish SALAD = new Dish(SALAD_ID, "salad");
    public static final Dish WATER = new Dish(WATER_ID, "water");

    public static final Dish BREAD_UPDATED = new Dish(BREAD_ID, "bread2");

    public static Dish getNew() {
        return new Dish(null, "ice-cream");
    }


    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
